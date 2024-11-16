import java.util.List;

class SingleChoiceQuestion extends Question {
    public SingleChoiceQuestion(String questionText, List<String> options, String correctAnswer) {
        super(questionText, options, correctAnswer);
    }

    @Override
    public String getType() {
        return "Question with single answer";
    }
}