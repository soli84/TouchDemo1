package com.example.jbt.touchdemo1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class Activity2 extends ActionBarActivity implements View.OnTouchListener {

    float x;
    TextView txtSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        findViewById(R.id.layout2).setOnTouchListener(this);
        txtSwipe = (TextView) findViewById(R.id.txtSwiped);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                // save first contact X
                x = event.getX();
                break;

            case MotionEvent.ACTION_MOVE:
                float x2 = event.getX();
                if(x + 200 < x2 ){
                    txtSwipe.setText("You swiped RIGHT!");
                }
                else if(x - 200 > x2){
                    txtSwipe.setText("You swiped LEFT!");
                }
                break;
        }
        return true;
    }
}
