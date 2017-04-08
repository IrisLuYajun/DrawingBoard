package com.irislu.administrator.drawingboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn;
    private Button p_bule;
    private Button p_green;
    private Button p_red;
    private Button p_black;
    private MyView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.clear);
        p_bule = (Button) findViewById(R.id.p_colorbule);
        p_green = (Button) findViewById(R.id.p_colorgreen);
        p_red = (Button) findViewById(R.id.p_colorred);
        p_black = (Button) findViewById(R.id.p_colorblack);
        view = (MyView) findViewById(R.id.draw);
        btn.setOnClickListener(this);
        p_green.setOnClickListener(this);
        p_bule.setOnClickListener(this);
        p_red.setOnClickListener(this);
        p_black.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clear:
                view.clear();
                break;
            case R.id.p_colorbule:
                view.getP().setColor(Color.BLUE);
                break;
            case R.id.p_colorgreen:
                view.getP().setColor(Color.GREEN);
                break;
            case R.id.p_colorred:
                view.getP().setColor(Color.RED);
                break;
            case R.id.p_colorblack:
                view.getP().setColor(Color.BLACK);
                break;
        }
    }

}
