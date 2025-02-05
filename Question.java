package ergasia.trivia;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private String correctAnswer;

    public Question(String questionText, List<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect(String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer);
    }
}

