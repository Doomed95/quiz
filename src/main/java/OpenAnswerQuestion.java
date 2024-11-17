import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenAnswerQuestion extends Question {
    private final String correctAnswer;

    public OpenAnswerQuestion(String questionText, String correctAnswer) {
        super(questionText, "Open answer question", null); // No options for open answer
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