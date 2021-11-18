package com.example.bp_fall_2021_quizapp;

public class QuestionModel {

    private String question;
    private String[] options;
    private int correctAnsNum;

    /**
     * Constructor - special method that initializes instances of the Question Model
     * @param question
     * @param opt1
     * @param opt2
     * @param opt3
     * @param opt4
     * @param correctAnsNum
     */
    public QuestionModel(String question, String opt1, String opt2, String opt3, String opt4, int correctAnsNum) {
        this.question = question;
        this.options = new String[] {opt1, opt2, opt3, opt4};
        this.correctAnsNum = correctAnsNum;
    }

    /**
     * Getters allow us to access private variables from other classes
     * @return
     */
    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {return options;}

    // button indexes go 0, 1, 2, 3... so we must subtract one here
    public int getCorrectAnsNum() {
        return correctAnsNum - 1;
    }
}


