import java.util.List;

public abstract class Question {
    private final String questionText;

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public abstract boolean isCorrect(String userAnswer);
    public abstract String getCorrectAnswer();
    public abstract List<String> getOptions();

}
