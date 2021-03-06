package com.example.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * This Activity about making a quiz for Android beginner developer like me.
 * The app include variety of questions, it also includes submit button to check the response
 * and give a grading, I've added a menuItem to also submit the responses to help user submit his
 * answers rapidly and not to scroll every time to the end.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Radio Groups of different question.
    RadioGroup questionFourRg, questionNineRg, questionSevenRg, questionSixRg, questionOneRg;
    // The Edit Text for the question 3 and 8.
    EditText eightQuestionEt, thirdQuestionEt;
    // The Response Checkboxes for question 2, 5 and 10.
    CheckBox intCb, charCb, doubleCb, floatCb;
    CheckBox happyLayoutCb, clickLayoutCb, absoluteLayoutCb, scrollLayoutCb;
    CheckBox kotlinCb, javaCb, phpCb, rubyCb;
    // Toast variable to display toast.
    Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // adding listener to the submit button.
        findViewById(R.id.submit_button).setOnClickListener(this);
        // initializing The EditTexts.
        eightQuestionEt = findViewById(R.id.edit_text_eight);
        thirdQuestionEt = findViewById(R.id.edit_text_three);
        // initializing The RadioGroups.
        questionSixRg = findViewById(R.id.question_six_radio_group);
        questionSevenRg = findViewById(R.id.question_seven_radio_group);
        questionNineRg = findViewById(R.id.question_nine_radio_group);
        questionOneRg = findViewById(R.id.question_one_radio_group);
        questionFourRg = findViewById(R.id.question_four_radio_group);
        // initializing The CheckBoxes.
        kotlinCb = findViewById(R.id.question_two_r1);
        javaCb = findViewById(R.id.question_two_r2);
        phpCb = findViewById(R.id.question_two_r3);
        rubyCb = findViewById(R.id.question_two_r4);
        intCb = findViewById(R.id.question_ten_r1);
        charCb = findViewById(R.id.question_ten_r2);
        floatCb = findViewById(R.id.question_ten_r3);
        doubleCb = findViewById(R.id.question_ten_r4);
        clickLayoutCb = findViewById(R.id.question_five_r4);
        happyLayoutCb = findViewById(R.id.question_five_r2);
        scrollLayoutCb = findViewById(R.id.question_five_r1);
        absoluteLayoutCb = findViewById(R.id.question_five_r3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit_button:
                gradingProcess();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.submit_menu_item:
                gradingProcess();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * this method is the main process of the quiz app, it pass throw out each question and see if
     * the correct response is selected of typed, if so it will update a variable call point
     * that will hold the result points, and finally we output this result via a Toast message.
     */
    private void gradingProcess() {
        int point = 0;
        // Question one checking process.
        int checked = questionOneRg.getCheckedRadioButtonId();
        if (checked == R.id.question_one_r2) point++;
        // Question Two checking process.
        if (kotlinCb.isChecked() && javaCb.isChecked() && !phpCb.isChecked() && !rubyCb.isChecked())
            point++;
        // Question Three checking process.
        String responseEt = thirdQuestionEt.getText().toString().trim().toLowerCase();
        if (responseEt.equals("view")) point++;
        // Question Four checking process.
        checked = questionFourRg.getCheckedRadioButtonId();
        if (checked == R.id.question_four_r2) point++;
        // Question Five checking process.
        if (happyLayoutCb.isChecked() && clickLayoutCb.isChecked() && !absoluteLayoutCb.isChecked() && !scrollLayoutCb.isChecked())
            point++;
        // Question Six checking process.
        checked = questionSixRg.getCheckedRadioButtonId();
        if (checked == R.id.question_six_r1) point++;
        // Question Seven checking process.
        checked = questionSevenRg.getCheckedRadioButtonId();
        if (checked == R.id.question_seven_r1) point++;
        // Question Eight checking process.
        responseEt = eightQuestionEt.getText().toString().trim().toLowerCase();
        if (responseEt.equals("class")) point++;
        // Question Nine checking process.
        checked = questionNineRg.getCheckedRadioButtonId();
        if (checked == R.id.question_nine_r1) point++;
        // Question Ten checking process.
        if (intCb.isChecked() && charCb.isChecked() && floatCb.isChecked() && doubleCb.isChecked())
            point++;
        // Displaying the Score. Checking if a Toast is Displayed then cancel it.
        if (mToast != null)
            mToast.cancel();
        mToast = Toast.makeText(this, "You got a score of " + point + "/10", Toast.LENGTH_SHORT);
        mToast.show();
    }
}
