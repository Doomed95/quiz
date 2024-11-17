import java.util.List;

public class SingleChoiceQuestion extends Question {
    private final List<String> options;
    private final String correctAnswer;

    public SingleChoiceQuestion(String questionText, List<String> options, String correctAnswer) {
        super(questionText);
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean isCorrect(String userAnswer){
        return correctAnswer.equalsIgnoreCase(userAnswer.trim().toLowerCase());
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public List<String> getOptions() {
        return options;
    }
}