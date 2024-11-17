class Answer {
    private final Question question;
    private final String userAnswer;

    public Answer(Question question, String userAnswer) {
        this.question = question;
        this.userAnswer = userAnswer;
    }

    public boolean isCorrect() {
        return question.isCorrect(userAnswer);
    }

    @Override
    public String toString(){
        return "Question: " + question.getQuestionText() +
                "\nYour answer: " + userAnswer +
                "\nCorrect answer: " + question.getCorrectAnswer() +
                "\n" + (isCorrect() ? "Correct!" : "Incorrect") + "\n";
    }
}
