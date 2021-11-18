package com.example.bp_fall_2021_quizapp;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class QuizQuestionActivity extends AppCompatActivity {

    // UI components here
    RadioButton[] answers;
    ProgressBar progressBar;
    Button SubmitButton;
    RadioGroup answerGroup;
    TextView question;
    // other variables here
    private ArrayList<QuestionModel> questions;
    int numberOfQuestions;
    int score;
    int questionsCompleted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        // create arraylist of questions
        questions = new ArrayList<QuestionModel>();
        // get username intent from main activity screen

        // initialize views using findViewByID
         answers = new RadioButton[4];
         answers[0] = findViewById(R.id.answer1);
         answers[1] = findViewById(R.id.answer2);
         answers[2] = findViewById(R.id.answer3);
         answers[3] = findViewById(R.id.answer4);

         answerGroup = findViewById(R.id.answers);
         question = findViewById(R.id.question);
         SubmitButton = findViewById(R.id.SubmitButton);
        // use helper method to add question content to arraylist
        addQuestions();
        // get total number of questions
        numberOfQuestions = questions.size();
        // set progress bar
        progressBar = findViewById(R.id.ProgressBar);
        progressBar.setProgress(0);
        // use helper method to proceed to next question
        showNextQuestion();
    }

    /**
     * Method that adds questions to our questions arraylist, using the Question Model constructor
     */
    private void addQuestions(){
        // question 1
        questions.add( new QuestionModel("What is Soba noodles made out of?",
                "Buckwheat", "Rye", "Sorghum", "Wheat", 1));
        // question 2
        questions.add( new QuestionModel("Why type of beans are used in baked beans?",
                "Pinto Beans", "Haricot Beans", "Flat Beans", "Black Beans", 2));
        // question 3
        questions.add( new QuestionModel("What is the most expensive spice on earth?",
                "Fenugreek", "Cardamom", "Saffron", "Nutmeg", 3));
        // question 4
        questions.add( new QuestionModel("What was the first food to be eaten in outer space?",
                "Applesauce", "Pizza", "Ice Cream", "Rice", 1));
        // question 5
        questions.add( new QuestionModel("When did humans start cooking?",
                "100,000 years ago", "1 million years ago", "1.8-2.3 million years ago", "100 years ago", 3));
    }

    /**
     * Check the answer when user clicks submit and move on to next question
     */

    public void submitQuestion(View view) {
        // if no options have been selected, prompt user to select an answer
        if (answerGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getBaseContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
        } else {
            // use helper methods to check the answer and show the next question
            checkAnswer();
            showNextQuestion();
        }
    }

    /**
     * Display next question. If finished, move onto results screen
     */
    private void showNextQuestion(){

        // clear previous button selections
        answerGroup.clearCheck();
        // if you haven't gone through all the questions yet
            // set the question & text to the next question
            // increase question number
            // set progress bar
        if (questionsCompleted+1 != questions.size()) {
            String[] options = questions.get(questionsCompleted).getOptions();
            for (int i = 0; i < options.length; i++) {
                answers[i].setText(options[i]);
            }
            question.setText(questions.get(questionsCompleted).getQuestion());
            questionsCompleted++;
        } else {
            Intent intent = new Intent(this, ResultActivity.class);
            startActivity(intent);
            finish(); // close current activity

        }


    }

    /**
     * Checks the answer and increases score if correct
     */
    private void checkAnswer(){
        // see which answer they picked
        String answer = findViewById(answerGroup.getCheckedRadioButtonId()).toString();
        // increase score if correct
        QuestionModel QuestionObject = questions.get(questionsCompleted);
        if (answer == QuestionObject.getOptions()[QuestionObject.getCorrectAnsNum()]) {
            score++;
        }
        double progress = questionsCompleted / questions.size() * 100;
        progressBar.setProgress((int) progress);
    }
}