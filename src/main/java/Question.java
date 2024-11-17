import java.util.List;

public abstract class Question {
    private final String questionText;
    private final String type;
    private final List<String> options;

    public Question(String questionText, String type, List<String> options) {
        this.questionText = questionText;
        this.type = type;
        this.options = options;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getType(){
        return type;
    }

    public List<String> getOptions() {
        return options;
    }

    public abstract String getCorrectAnswer();

    public abstract boolean isCorrect(String userAnswer);
}
