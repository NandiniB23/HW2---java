package com.HW2;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private static int questionCounter = 1;
    private int id;
    private String title;
    private String body;
    private List<Answer> answers;

    public Question(String title, String body) {
        if (title == null || title.isEmpty() || body == null || body.isEmpty()) {
            throw new IllegalArgumentException("Title and body cannot be empty.");
        }
        this.id = questionCounter++;
        this.title = title;
        this.body = body;
        this.answers = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getBody() { return body; }
    public List<Answer> getAnswers() { return answers; }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty.");
        this.title = title;
    }

    public void setBody(String body) {
        if (body == null || body.isEmpty()) throw new IllegalArgumentException("Body cannot be empty.");
        this.body = body;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void removeAnswer(Answer answer) {
        answers.remove(answer);
    }

    @Override
    public String toString() {
        return " Q" + id + ": " + title + "\n   " + body + "\n    Answers: " + answers.size();
    }
}
