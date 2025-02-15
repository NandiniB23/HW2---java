package com.hw2;

public class Answer {
    private static int answerCounter = 1;
    private int id;
    private String body;

    public Answer(String body) {
        if (body == null || body.isEmpty()) {
            throw new IllegalArgumentException("Answer body cannot be empty.");
        }
        this.id = answerCounter++;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        if (body == null || body.isEmpty()) {
            throw new IllegalArgumentException("Answer body cannot be empty.");
        }
        this.body = body;
    }

    @Override
    public String toString() {
        return "A" + id + ": " + body;
    }
}
