package com.example.tipper.quiz;

public class Quiz {
    private int question;
    private boolean answer;

    public Quiz(int question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    public int getQuestion() {
        return this.question;
    }

    public void setQuestion(int questionIndex) {
        this.question = questionIndex;
    }

    public boolean getAnswer() {
        return this.answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
