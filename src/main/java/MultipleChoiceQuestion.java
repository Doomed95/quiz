import java.util.Arrays;
import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private final String correctAnswer;

    public MultipleChoiceQuestion(String questionText, List<String> options, String correctAnswer) {
        super(questionText, "Question with multiple answers", options);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public boolean isCorrect(String userAnswer) {
        String normalizedUserAnswer = userAnswer.trim().toLowerCase();
        return normalizedUserAnswer.chars().allMatch(c -> correctAnswer.contains(Character.toString(c)))
                && normalizedUserAnswer.length() == correctAnswer.length();
    }
}