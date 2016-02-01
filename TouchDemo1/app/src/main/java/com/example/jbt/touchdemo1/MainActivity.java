package com.example.jbt.touchdemo1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnTouchListener {

    TextView txtAction, txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.layout).setOnTouchListener(this);
        txtData = (TextView) findViewById(R.id.txtData);
        txtAction = (TextView) findViewById(R.id.txtAction);

        findViewById(R.id.btnAct2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, Activity2.class);
                startActivity(in);
            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //txtAction.setText("Action: " + event.getAction());
        String action = "";
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                action = "DOWN!";
                break;

            case MotionEvent.ACTION_UP:
                action = "UP....";
                break;

            case MotionEvent.ACTION_MOVE:
                action = "MOVING :)";
                break;
        }
        txtAction.setText(action);
        txtData.setText("X = " + event.getX() +", Y = " + event.getY());
        return true;
    }
}
