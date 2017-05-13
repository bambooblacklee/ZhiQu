package com.bamboolmc.zhiqu.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bamboolmc.zhiqu.R;

public class TestActivity extends AppCompatActivity {

    private static final String MOVIE_ID = "movie_id";
    private int movieId;//电影Id

    public static void startActivity(Context context, int movieId) {
        Intent starter = new Intent(context, TestActivity.class);
        starter.putExtra(MOVIE_ID, movieId);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        movieId = getIntent().getIntExtra(MOVIE_ID, 0);
        TextView text = (TextView)findViewById(R.id.test_tv);
        text.setText(""+movieId);

         Handler uiHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };



    }
}
