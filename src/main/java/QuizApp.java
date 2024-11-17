import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz Application!");

        int quizChoice = -1;
        while (true) {
            try {
                System.out.println("Please choose a quiz to begin:");
                System.out.println("1. Math Quiz");
                System.out.println("2. General Knowledge Quiz");

                quizChoice = Integer.parseInt(scanner.nextLine());

                if (quizChoice == 1 || quizChoice == 2) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

        Quiz selectedQuiz;
        if (quizChoice == 1) {
            selectedQuiz = createMathQuiz();
        } else {
            selectedQuiz = createGeneralKnowledgeQuiz();
        }

        System.out.println("Welcome to " + selectedQuiz.name());
        System.out.println("This quiz has " + selectedQuiz.questions().size() + " questions.");

        int score = 0;

        List<Answer> answers = new ArrayList<>();

        for (Question question : selectedQuiz.questions()) {
            System.out.println(question.getQuestionText() + " (" + question.getType() + ")");

            String userAnswer = "";

            if (question instanceof OpenAnswerQuestion) {
                System.out.print("Your answer: ");
                userAnswer = scanner.nextLine(); // No need for validation for open answer
            } else {
                // Display options for single and multiple choice question
                for (int i = 0; i < question.getOptions().size(); i++) {
                    System.out.println((char) ('a' + i) + ". " + question.getOptions().get(i));
                }

                // Validate input for valid choices (a, b, c, d)
                while (true) {
                    System.out.print("Your answer: ");
                    userAnswer = scanner.nextLine();
                    boolean isValid = true;

                    if (question instanceof SingleChoiceQuestion) {
                        isValid = userAnswer.length() == 1 && "abcd".contains(userAnswer);
                    } else if (question instanceof MultipleChoiceQuestion) {
                        for (char c : userAnswer.toCharArray()) {
                            if (!"abcd".contains(String.valueOf(c))) {
                                isValid = false;
                                break;
                            }
                        }
                    }
                    if (isValid) {
                        break;
                    } else {
                        System.out.println("Invalid answer. Please enter only valid options (e.g., a, b, c, d).");
                    }
                }
            }

            Answer answer = new Answer(question, userAnswer);
            answers.add(answer);
            if (answer.isCorrect()) {
                score++;
            }
        }

        System.out.println("You had " + score + "/" + selectedQuiz.questions().size() + " answers correct!");

        System.out.println("Would you like to try another quiz? (yes/no)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            main(args); // Restart the application
        } else {
            System.out.println("Thank you for playing!");
        }
        scanner.close();
    }

    private static Quiz createMathQuiz() {
        List<Question> questions = new ArrayList<>();
        questions.add(new SingleChoiceQuestion("What is 2 + 2?", List.of("5", "4", "8", "2"), "b"));
        questions.add(new SingleChoiceQuestion("What is 2 + 5?", List.of("4", "7", "6", "10"), "b"));
        questions.add(new MultipleChoiceQuestion("4 = ?", List.of("2^2", "-2^2", "1 + 3", "4^1"), "abcd"));
        questions.add(new OpenAnswerQuestion("What is the square root of 16?", "4"));

        return new Quiz("Math Quiz", questions);
    }

    private static Quiz createGeneralKnowledgeQuiz() {
        List<Question> questions = new ArrayList<>();
        questions.add(new SingleChoiceQuestion("Who developed the theory of relativity?", List.of("Isaac Newton", "Albert Einstein", "Stephen Hawking", "Nicolas Tesla"), "b"));
        questions.add(new SingleChoiceQuestion("What is the capital of France?", List.of("Berlin", "Paris", "Moscow", "Prague"), "b"));
        questions.add(new MultipleChoiceQuestion("Which of the following are programming languages?", List.of("Java", "Windows", "C++", "Linux"), "ac"));
        questions.add(new OpenAnswerQuestion("What is the freezing point of water in Celsius?", "0"));

        return new Quiz("General Knowledge Quiz", questions);
    }
}