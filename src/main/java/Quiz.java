import java.util.List;

class Quiz {
    private final String name;
    private final List<Question> questions;

    public Quiz(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}