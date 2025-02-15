package com.HW2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuestionManager questionManager = new QuestionManager();
        AnswerManager answerManager = new AnswerManager();

        while (true) {
            System.out.println("\n=================================");
            System.out.println("   Welcome to HW2 Q&A System");
            System.out.println("=================================");
            System.out.println("1. Add Question");
            System.out.println("2. View Questions");
            System.out.println("3. Update Question");
            System.out.println("4. Delete Question");
            System.out.println("5. Add Answer");
            System.out.println("6. Update Answer");
            System.out.println("7. Delete Answer");
            System.out.println("8. Upvote Answer");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = getValidIntInput(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter question title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter question body: ");
                    String body = scanner.nextLine();
                    questionManager.createQuestion(title, body);
                    break;

                case 2:
                    questionManager.readQuestions();
                    break;

                case 3:
                    int qid = getValidIntInput(scanner, "Enter question ID to update: ");
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new body: ");
                    String newBody = scanner.nextLine();
                    questionManager.updateQuestion(qid, newTitle, newBody);
                    break;

                case 4:
                    int deleteId = getValidIntInput(scanner, "Enter question ID to delete: ");
                    questionManager.deleteQuestion(deleteId);
                    break;

                case 5:
                    int ansQid = getValidIntInput(scanner, "Enter question ID to answer: ");
                    System.out.print("Enter answer: ");
                    String ansBody = scanner.nextLine();
                    answerManager.addAnswerToQuestion(questionManager, ansQid, ansBody);
                    break;

                case 6:
                    int upQid = getValidIntInput(scanner, "Enter question ID: ");
                    int ansId = getValidIntInput(scanner, "Enter answer ID to update: ");
                    System.out.print("Enter new answer body: ");
                    String newAnsBody = scanner.nextLine();
                    answerManager.updateAnswer(questionManager, upQid, ansId, newAnsBody);
                    break;

                case 7:
                    int delQid = getValidIntInput(scanner, "Enter question ID: ");
                    int delAnsId = getValidIntInput(scanner, "Enter answer ID to delete: ");
                    answerManager.deleteAnswer(questionManager, delQid, delAnsId);
                    break;

                case 8:
                    int voteQid = getValidIntInput(scanner, "Enter question ID: ");
                    int voteAnsId = getValidIntInput(scanner, "Enter answer ID to upvote: ");
                    answerManager.upvoteAnswer(questionManager, voteQid, voteAnsId);
                    break;

                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Helper method to validate integer input
    public static int getValidIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear invalid input
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
    }

    // Overloaded method to display a prompt
    public static int getValidIntInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return getValidIntInput(scanner);
    }
}
