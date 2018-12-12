package com.example.scorekeeper;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int aTeamGoals = 0, bTeamGoals = 0, aTeamFouls = 0,
            bTeamFouls = 0, aTeamCorners = 0, bTeamCorners = 0;

    private TextView aGoalsTv, bGoalsTv, aFoulsTv,
            bFoulsTv, aCornersTv, bCornersTv;

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

    @Override
    public void onClick(View viewClicked) {
        findViewById(R.id.reset_button).setEnabled(true);
        switch (viewClicked.getId()) {
            case R.id.team_a_corner_button:
                aTeamCorners++;
                changeTextView(aCornersTv, aTeamCorners);
                break;
            case R.id.team_b_corner_button:
                bTeamCorners++;
                changeTextView(bCornersTv, bTeamCorners);
                break;
            case R.id.team_a_foul_button:
                aTeamFouls++;
                changeTextView(aFoulsTv, aTeamFouls);
                break;
            case R.id.team_b_foul_button:
                bTeamFouls++;
                changeTextView(bFoulsTv, bTeamFouls);
                break;
            case R.id.team_a_goal_button:
                aTeamGoals++;
                changeTextView(aGoalsTv, aTeamGoals);
                break;
            case R.id.team_b_goal_button:
                bTeamGoals++;
                changeTextView(bGoalsTv, bTeamGoals);
                break;
            case R.id.reset_button:
                reset();
        }
    }

    /**
     * This Method reset the variables and the text views to the 0.
     */
    private void reset() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.reset)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
                })
                .setNegativeButton(R.string.cancel, null)
                .setMessage(R.string.reset_message).show();
    }

    /**
     * This method change the value of a given textView.
     *
     * @param textView the textView we want to change it's Text.
     * @param value    the value which we want to display in the TextView.
     */
    private void changeTextView(TextView textView, int value) {
        textView.setText(String.valueOf(value));
    }
}
