import java.util.List;

abstract class Question {
    protected String questionText;
    protected List<String> options;
    protected String correctAnswer;

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

    public abstract String getType();

    public boolean isCorrect(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}
