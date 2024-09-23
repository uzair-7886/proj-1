import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionService {
    private List<Question> questions;
    private List<String> selection;
    private FileHandler fileHandler;

    public QuestionService() {
        this.fileHandler = new FileHandler("questions.txt");
        this.questions = fileHandler.readQuestions();
        this.selection = new ArrayList<>();
    }

    public void playQuiz() {
        Scanner sc = new Scanner(System.in);
        for (Question q : questions) {
            System.out.println("Question no. : " + q.getId());
            System.out.println(q.getQuestion());
            System.out.println(q.getOpt1());
            System.out.println(q.getOpt2());
            System.out.println(q.getOpt3());
            System.out.println(q.getOpt4());
            selection.add(sc.nextLine());
        }

        for (String s : selection) {
            System.out.println(s);
        }
    }

    public void printScore() {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            Question que = questions.get(i);
            String answer = que.getAnswer();
            String userAnswer = selection.get(i);
            if (answer.equals(userAnswer)) {
                score++;
            }
        }
        System.out.println("Your score is : " + score);
    }

    public void addQuestions() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter question details (or type 'exit' to finish):");
            System.out.print("Question: ");
            String question = sc.nextLine();
            if (question.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.print("Option 1: ");
            String opt1 = sc.nextLine();
            System.out.print("Option 2: ");
            String opt2 = sc.nextLine();
            System.out.print("Option 3: ");
            String opt3 = sc.nextLine();
            System.out.print("Option 4: ");
            String opt4 = sc.nextLine();
            System.out.print("Correct Answer: ");
            String answer = sc.nextLine();

            int id = questions.size() + 1;
            Question newQuestion = new Question(id, question, opt1, opt2, opt3, opt4, answer);
            questions.add(newQuestion);
            fileHandler.writeQuestion(newQuestion);
        }
        System.out.println("Questions added successfully.");
    }
}