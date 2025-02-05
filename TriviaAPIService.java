package ergasia.trivia;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriviaAPIService {
    private String apiUrl;

    public TriviaAPIService(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public List<TriviaInfo> getQuestions(int amount) throws Exception {
        List<TriviaInfo> questions = new ArrayList<>();
        URL url = new URL(apiUrl + "?amount=" + amount);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new Exception("Error: Received HTTP code " + conn.getResponseCode());
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray results = jsonResponse.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {
                JSONObject obj = results.getJSONObject(i);
                String category = obj.getString("category");
                String type = obj.getString("type");
                String questionText = obj.getString("question");
                String correctAnswer = obj.getString("correct_answer");

                List<String> incorrectAnswers = new ArrayList<>();
                JSONArray incorrectArray = obj.getJSONArray("incorrect_answers");
                for (int j = 0; j < incorrectArray.length(); j++) {
                    incorrectAnswers.add(incorrectArray.getString(j));
                }

                // Ανακάτεμα απαντήσεων
                List<String> allAnswers = new ArrayList<>(incorrectAnswers);
                allAnswers.add(correctAnswer);
                Collections.shuffle(allAnswers);

                questions.add(new TriviaInfo(category, type, questionText, correctAnswer, allAnswers));
            }
        } catch (Exception e) {
            throw new Exception("Error while parsing JSON response: " + e.getMessage());
        }
        return questions;
    }
}
