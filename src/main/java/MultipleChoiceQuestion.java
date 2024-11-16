import java.util.Arrays;
import java.util.List;

class MultipleChoiceQuestion extends Question {
    public MultipleChoiceQuestion(String questionText, List<String> options, String correctAnswer) {
        super(questionText, options, correctAnswer);
    }

    @Override
    public String getType() {
        return "Question with multiple answers";
    }

    @Override
    public boolean isCorrect(String answer) {
        // Sort both the correct answer and the user input alphabetically for comparison
        char[] correct = correctAnswer.toLowerCase().toCharArray();
        char[] user = answer.toLowerCase().toCharArray();
        Arrays.sort(correct);
        Arrays.sort(user);
        return Arrays.equals(correct, user);
    }
}