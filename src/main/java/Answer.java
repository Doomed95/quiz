class Answer {
    private final Question question;
    private final String userAnswer;
    private final boolean isCorrect;

    public Answer(Question question, String userAnswer) {
        this.question = question;
        this.userAnswer = userAnswer;
        this.isCorrect = question.isCorrect(userAnswer);
    }

    public Question getQuestion() {
        return question;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
