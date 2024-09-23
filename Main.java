import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuestionService questionService = new QuestionService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select mode:");
        System.out.println("1. User mode");
        System.out.println("2. Instructor mode");
        int mode = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (mode == 1) {
            questionService.playQuiz();
            questionService.printScore();
        } else if (mode == 2) {
            questionService.addQuestions();
        } else {
            System.out.println("Invalid mode selected.");
        }
    }
}