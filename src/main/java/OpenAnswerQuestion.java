import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OpenAnswerQuestion extends Question {
    public OpenAnswerQuestion(String questionText, String correctAnswer) {
        super(questionText, new ArrayList<>(), correctAnswer); // No options for open answer
    }

    @Override
    public String getType() {
        return "Open answer question";
    }

    @Override
    public List<String> getOptions() {
        return Collections.emptyList(); // Return an empty list since there are no options
    }
}