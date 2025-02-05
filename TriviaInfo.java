package ergasia.trivia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriviaInfo {
    private final String category;
    private final String type;
    private final String question;
    private final String correctAnswer;
    private final List<String> incorrectAnswers;
    private final List<String> allAnswers; // Προσθήκη μεταβλητής για σταθερή σειρά απαντήσεων

    public TriviaInfo(String category, String type, String question, String correctAnswer, List<String> incorrectAnswers) {
        this.category = category;
        this.type = type;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = new ArrayList<>(incorrectAnswers);
        
        // Δημιουργία και αποθήκευση της λίστας απαντήσεων
        this.allAnswers = new ArrayList<>(incorrectAnswers);
        this.allAnswers.add(correctAnswer);
        Collections.shuffle(this.allAnswers);
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getIncorrectAnswers() {
        return new ArrayList<>(incorrectAnswers); // Επιστροφή νέου αντικειμένου για ασφάλεια
    }

    public List<String> getAllAnswers() {
        return allAnswers; // Επιστρέφει την ήδη ανακατεμένη λίστα
    }

    public boolean isCorrect(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}
