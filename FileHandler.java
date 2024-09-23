import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public List<Question> readQuestions() {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 7) {
                    int id = Integer.parseInt(parts[0]);
                    Question question = new Question(id, parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                    questions.add(question);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading questions from file: " + e.getMessage());
        }
        return questions;
    }

    public void writeQuestion(Question question) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String line = String.format("%d|%s|%s|%s|%s|%s|%s%n",
                    question.getId(),
                    question.getQuestion(),
                    question.getOpt1(),
                    question.getOpt2(),
                    question.getOpt3(),
                    question.getOpt4(),
                    question.getAnswer());
            writer.write(line);
        } catch (IOException e) {
            System.out.println("Error writing question to file: " + e.getMessage());
        }
    }
}