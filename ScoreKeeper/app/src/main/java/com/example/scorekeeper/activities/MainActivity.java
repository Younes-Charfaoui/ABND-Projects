package com.example.scorekeeper.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.scorekeeper.R;

/**
 * We choose the Soccer Sport to make a Score Keeper App the holds some metrics
 * for both teams : A and B, the metrics are the Goals, Fouls and Corners, each one is
 * incremented by one.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DialogInterface.OnClickListener {

    // integers variables to hold the current metrics of the game.
    private int aTeamGoals = 0;
    private int bTeamGoals = 0;
    private int aTeamFouls = 0;
    private int bTeamFouls = 0;
    private int aTeamCorners = 0;
    private int bTeamCorners = 0;

    // textViews variables to reference the textViews.
    private TextView aGoalsTv;
    private TextView bGoalsTv;
    private TextView aFoulsTv;
    private TextView bFoulsTv;
    private TextView aCornersTv;
    private TextView bCornersTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // adding the listeners to buttons.
        findViewById(R.id.team_a_corner_button).setOnClickListener(this);
        findViewById(R.id.team_b_corner_button).setOnClickListener(this);
        findViewById(R.id.team_a_foul_button).setOnClickListener(this);
        findViewById(R.id.team_b_foul_button).setOnClickListener(this);
        findViewById(R.id.team_a_goal_button).setOnClickListener(this);
        findViewById(R.id.team_b_goal_button).setOnClickListener(this);
        findViewById(R.id.reset_button).setOnClickListener(this);
        // initializing the textViews.
        aFoulsTv = findViewById(R.id.team_a_fouls_tv);
        bFoulsTv = findViewById(R.id.team_b_fouls_tv);
        aCornersTv = findViewById(R.id.team_a_corner_tv);
        bCornersTv = findViewById(R.id.team_b_corner_tv);
        aGoalsTv = findViewById(R.id.team_a_goals_tv);
        bGoalsTv = findViewById(R.id.team_b_goals_tv);
    }

    /**
     * The overridden method by the ClickListener Interface to handle view click.
     *
     * @param viewClicked tells which view was clicked.
     */
    @Override
    public void onClick(View viewClicked) {
        if (!findViewById(R.id.reset_button).isEnabled())
            findViewById(R.id.reset_button).setEnabled(true);
        switch (viewClicked.getId()) {
            case R.id.team_a_corner_button:
                changeTextView(aCornersTv, ++aTeamCorners);
                break;
            case R.id.team_b_corner_button:
                changeTextView(bCornersTv, ++bTeamCorners);
                break;
            case R.id.team_a_foul_button:
                changeTextView(aFoulsTv, ++aTeamFouls);
                break;
            case R.id.team_b_foul_button:
                changeTextView(bFoulsTv, ++bTeamFouls);
                break;
            case R.id.team_a_goal_button:
                changeTextView(aGoalsTv, ++aTeamGoals);
                break;
            case R.id.team_b_goal_button:
                changeTextView(bGoalsTv, ++bTeamGoals);
                break;
            case R.id.reset_button:
                reset();
        }
    }

    /**
     * This Method displays dialog to reset or not the variables and the
     * text views to the 0.
     */
    private void reset() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.reset)
                .setPositiveButton(android.R.string.ok, this)
                .setNegativeButton(R.string.cancel, null)
                .setMessage(R.string.reset_message).show();
    }

    /**
     * this method make the necessary action to reset the variable and the texts.
     */
    private void resetProcedure() {
        aTeamGoals = 0;
        bTeamGoals = 0;
        aTeamFouls = 0;
        bTeamFouls = 0;
        aTeamCorners = 0;
        bTeamCorners = 0;
        changeTextView(aCornersTv, 0);
        changeTextView(bCornersTv, 0);
        changeTextView(aFoulsTv, 0);
        changeTextView(bFoulsTv, 0);
        changeTextView(aGoalsTv, 0);
        changeTextView(bGoalsTv, 0);
        findViewById(R.id.reset_button).setEnabled(false);
    }

    /**
     * This method change the value of a given textView.
     *
     * @param textView the textView we want to change it's Text.
     * @param value    the value which we want to display in the TextView.
     */
    private void changeTextView(TextView textView, int value) {
        /*
         * we cant let user update a textView by more than 1000, because I don't think that we
         * can pass this number in real soccer game. I think 100 is better but I choose 1000.
         */
        if (value <= 1000)
            textView.setText(String.valueOf(value));
    }

    /**
     * The Overridden method by the Dialog Interface to handing clicks.
     *
     * @param dialog which dialog the click was on.
     * @param which  button was pressed.
     */
    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE)
            resetProcedure();
    }
}
