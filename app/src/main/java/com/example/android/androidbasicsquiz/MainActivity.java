package com.example.android.androidbasicsquiz;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int studentScore = 0;
    static final int TOTAL_NUM_OF_QUESTIONS = 6;

    RadioButton question1RadioButton;
    RadioButton question2RadioButton;
    EditText question3EditText;
    RadioButton question4RadioButton;
    EditText question5EditText;
    CheckBox drawableBox;
    CheckBox layoutBox;
    CheckBox manifestsBox;
    CheckBox valuesBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question1RadioButton = findViewById(R.id.boolean_radio_button);
        question2RadioButton = findViewById(R.id.edit_text_radio_button);
        question3EditText = findViewById(R.id.question_3_edit_text);
        question4RadioButton = findViewById(R.id.on_click_radio_button);
        question5EditText = findViewById(R.id.question_5_edit_text);
        drawableBox = findViewById(R.id.drawable_checkbox);
        layoutBox = findViewById(R.id.layout_checkbox);
        manifestsBox = findViewById(R.id.manifests_checkbox);
        valuesBox = findViewById(R.id.values_checkbox);
    }

    public void submitAnswersButtonTapped(View view) {
        checkQuestionOne();
        checkQuestionTwo();
        checkQuestionThree();
        checkQuestionFour();
        checkQuestionFive();
        checkQuestionSix();

        displayStudentScore();
    }

    private void checkQuestionOne() {
        if (question1RadioButton.isChecked()) {
            studentScore += 1;
        }
    }

    private void checkQuestionTwo() {
        if (question2RadioButton.isChecked()) {
            studentScore += 1;
        }
    }

    private void checkQuestionThree() {
        String equalityAnswer = question3EditText.getText().toString();

        if (equalityAnswer.trim().equals("==")) {
            studentScore += 1;
        }
    }

    private void checkQuestionFour() {
        if (question4RadioButton.isChecked()) {
            studentScore += 1;
        }
    }

    private void checkQuestionFive() {
        String instantiateAnswer = question5EditText.getText().toString();

        if (instantiateAnswer.trim().toLowerCase().equals("new")) {
            studentScore += 1;
        }
    }

    private void checkQuestionSix() {
        if (drawableBox.isChecked() && layoutBox.isChecked() &&
                !manifestsBox.isChecked() && valuesBox.isChecked()) {
            studentScore += 1;
        }
    }

    private void displayStudentScore() {
        Resources res = getResources();
        String msg = "";

        if (studentScore == TOTAL_NUM_OF_QUESTIONS) {
            msg = res.getString(R.string.toast_all_correct);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        } else if (studentScore == 0) {
            msg = res.getString(R.string.toast_none_correct);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        } else {
            msg = "You got " + studentScore + " out of " + TOTAL_NUM_OF_QUESTIONS + " questions right.";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }

        studentScore = 0;
    }
}
