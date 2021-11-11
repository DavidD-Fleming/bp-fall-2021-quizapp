package com.example.bp_fall_2021_quizapp;

import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class QuizQuestionActivity extends AppCompatActivity {

    // UI components here
    RadioButton answer1;
    RadioButton answer2;
    RadioButton answer3;
    RadioButton answer4;
    RadioButton answer5;
    ProgressBar progressBar;
    // other variables here
    private ArrayList<QuestionModel> questions;
    int numberOfQuestions;
    int correctAnswers;
    int questionsCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        // create arraylist of questions
        questions = new ArrayList<QuestionModel>();
        // get username intent from main activity screen
        // initialize views using findViewByID
         answer1 = findViewById(R.id.answer1);
         answer2 = findViewById(R.id.answer2);
         answer3 = findViewById(R.id.answer3);
         answer4 = findViewById(R.id.answer4);
         answer5 = findViewById(R.id.answer5);
        // use helper method to add question content to arraylist
        addQuestions();
        // get total number of questions
        numberOfQuestions = questions.size();
        // set progress bar
        progressBar = findViewById(R.id.ProgressBar);

        int progress = (int) Math.round(100 * questionsCompleted/numberOfQuestions);

        progressBar.setProgress(progress);
        // use helper method to proceed to next question
        showNextQuestion();
    }

    /**
     * Method that adds questions to our questions arraylist, using the Question Model constructor
     */
    private void addQuestions(){
        // question 1
        questions.add( new QuestionModel("", "", "", "", "", 1));
        // question 2
        questions.add( new QuestionModel("", "", "", "", "", 1));
        // question 3
        questions.add( new QuestionModel("", "", "", "", "", 1));
        // question 4
        questions.add( new QuestionModel("", "", "", "", "", 1));
        // question 5
        questions.add( new QuestionModel("", "", "", "", "", 1));
    }

    /**
     * Check the answer when user clicks submit and move on to next question
     */
    public void submitQuestion(View view){
        // if no options have been selected, prompt user to select an answer

        // use helper methods to check the answer and show the next question

    }

    /**
     * Display next question. If finished, move onto results screen
     */
    private void showNextQuestion(){

        // clear previous button selections

        // if you haven't gone through all the questions yet
            // set the question & text to the next question
            // increase question number
            // set progress bar

        // if finished with quiz, start Results activity

    }

    /**
     * Checks the answer and increases score if correct
     */
    private void checkAnswer(){
        // see which answer they picked

        // increase score if correct

    }
}