package com.HW2;

public class AnswerManager {
    public void addAnswerToQuestion(QuestionManager qm, int questionId, String answerBody) {
        Question q = qm.findQuestionById(questionId);
        if (q != null) {
            q.addAnswer(new Answer(answerBody));
            System.out.println(" Answer added successfully!");
        } else {
            System.out.println("Question not found.");
        }
    }

    public void updateAnswer(QuestionManager qm, int questionId, int answerId, String newBody) {
        Question q = qm.findQuestionById(questionId);
        if (q != null) {
            for (Answer a : q.getAnswers()) {
                if (a.getId() == answerId) {
                    a.setBody(newBody);
                    System.out.println(" Answer updated successfully!");
                    return;
                }
            }
        }
        System.out.println("️ Answer not found.");
    }

    public void deleteAnswer(QuestionManager qm, int questionId, int answerId) {
        Question q = qm.findQuestionById(questionId);
        if (q != null) {
            q.getAnswers().removeIf(a -> a.getId() == answerId);
            System.out.println(" Answer deleted successfully!");
        } else {
            System.out.println(" Question not found.");
        }
    }

    public void upvoteAnswer(QuestionManager qm, int questionId, int answerId) {
        Question q = qm.findQuestionById(questionId);
        if (q != null) {
            for (Answer a : q.getAnswers()) {
                if (a.getId() == answerId) {
                    a.upvote();
                    System.out.println(" Answer upvoted!");
                    return;
                }
            }
        }
        System.out.println("️ Answer not found.");
    }
}
