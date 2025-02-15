package com.HW2;
import java.util.ArrayList;
import java.util.List;

public class QuestionManager {
    private List<Question> questions;

    public QuestionManager() {
        this.questions = new ArrayList<>();
    }

    public void createQuestion(String title, String body) {
        questions.add(new Question(title, body));
        System.out.println(" Question added successfully!");
    }

    public void readQuestions() {
        if (questions.isEmpty()) {
            System.out.println("️ No questions available.");
            return;
        }
        System.out.println("\n📌 All Questions (Newest First)");
        for (int i = questions.size() - 1; i >= 0; i--) { 
            System.out.println(questions.get(i));
        }
    }

    public Question findQuestionById(int id) {
        return questions.stream().filter(q -> q.getId() == id).findFirst().orElse(null);
    }

    public void updateQuestion(int id, String newTitle, String newBody) {
        Question q = findQuestionById(id);
        if (q != null) {
            q.setTitle(newTitle);
            q.setBody(newBody);
            System.out.println(" Question updated successfully.");
        } else {
            System.out.println("️ Question not found.");
        }
    }

    public void deleteQuestion(int id) {
        Question q = findQuestionById(id);
        if (q != null) {
            questions.remove(q);
            System.out.println(" Question deleted successfully.");
        } else {
            System.out.println(" Question not found.");
        }
    }
}
