package com.example.android.androidbasicsquiz;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        RadioButton booleanButton = (RadioButton) findViewById(R.id.boolean_radio_button);

        if (booleanButton.isChecked()) {
            studentScore += 1;
        }
    }

    private void checkQuestionTwo() {
        RadioButton editTextButton = (RadioButton) findViewById(R.id.edit_text_radio_button);
        RadioButton textAreaButton = (RadioButton) findViewById(R.id.text_area_radio_button);
        RadioButton textViewButton = (RadioButton) findViewById(R.id.text_view_radio_button);

        if (editTextButton.isChecked()) {
            studentScore += 1;
        }
    }

    private void checkQuestionThree() {
        EditText editText = (EditText) findViewById(R.id.question_3_edit_text);

        String equalityAnswer = editText.getText().toString();

        if (equalityAnswer.trim().equals("==")) {
            studentScore += 1;
        }
    }

    private void checkQuestionFour() {
        RadioButton onClickButton = (RadioButton) findViewById(R.id.on_click_radio_button);

        if (onClickButton.isChecked()) {
            studentScore += 1;
        }
    }

    private void checkQuestionFive() {
        EditText editText = (EditText) findViewById(R.id.question_5_edit_text);

        String instantiateAnswer = editText.getText().toString();

        if (instantiateAnswer.trim().toLowerCase().equals("new")) {
            studentScore += 1;
        }
    }

    private void checkQuestionSix() {
        CheckBox drawableBox = (CheckBox) findViewById(R.id.drawable_checkbox);
        CheckBox layoutBox = (CheckBox) findViewById(R.id.layout_checkbox);
        CheckBox manifestsBox = (CheckBox) findViewById(R.id.manifests_checkbox);
        CheckBox valuesBox = (CheckBox) findViewById(R.id.values_checkbox);

        if (drawableBox.isChecked() && layoutBox.isChecked() &&
                !manifestsBox.isChecked() && valuesBox.isChecked()) {
            studentScore += 1;
        }
    }

    private void displayStudentScore() {
        if (studentScore == TOTAL_NUM_OF_QUESTIONS) {
            Toast.makeText(this, "Congratulations for getting all the questions correct!", Toast.LENGTH_SHORT).show();
        } else if (studentScore == 0) {
            Toast.makeText(this, "Sorry, but you didn't get any question correct.", Toast.LENGTH_SHORT).show();
        } else {
            String msg = "You got " + studentScore + " out of " + TOTAL_NUM_OF_QUESTIONS + " questions right.";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }

        studentScore = 0;
    }
}
