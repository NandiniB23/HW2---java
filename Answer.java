package com.HW2;

public class Answer {
    private static int answerCounter = 1;
    private int id;
    private String body;
    private int upvotes = 0; // New Feature: Upvotes

    public Answer(String body) {
        if (body == null || body.isEmpty()) throw new IllegalArgumentException("Answer body cannot be empty.");
        this.id = answerCounter++;
        this.body = body;
    }

    public int getId() { return id; }
    public String getBody() { return body; }
    public int getUpvotes() { return upvotes; }

    public void setBody(String body) {
        if (body == null || body.isEmpty()) throw new IllegalArgumentException("Answer body cannot be empty.");
        this.body = body;
    }

    public void upvote() { upvotes++; } // New Feature: Upvote system

    @Override
    public String toString() {
        return "💬 A" + id + " (" + "👍 " + upvotes + "): " + body;
    }
}
