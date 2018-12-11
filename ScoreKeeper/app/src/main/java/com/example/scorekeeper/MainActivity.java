package com.example.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.team_a_corner_button).setOnClickListener(this);
        findViewById(R.id.team_b_corner_button).setOnClickListener(this);
        findViewById(R.id.team_a_foul_button).setOnClickListener(this);
        findViewById(R.id.team_b_foul_button).setOnClickListener(this);
        findViewById(R.id.team_a_goal_button).setOnClickListener(this);
        findViewById(R.id.team_b_goal_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}
