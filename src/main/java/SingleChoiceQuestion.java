import java.util.List;

public class SingleChoiceQuestion extends Question {
    private final String correctAnswer;

    public SingleChoiceQuestion(String questionText, List<String> options, String correctAnswer) {
        super(questionText, "Question with single answer", options);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public boolean isCorrect(String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer.trim());
    }
}