package com.bamboolmc.zhiqu.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BambooLmc on 17/4/6 下午9:47.
 *
 * butterknife在activity中无需unbind
 * This should only be used in the {@code onDestroyView} method of a fragment.
 */
public class SplashActivity extends AppCompatActivity {

    @BindView(R2.id.tv_skip)
    TextView mTvSkip;

    private boolean flag = false;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        runnable = new Runnable() {
            @Override
            public void run() {
                goMain();
            }
        };

        mTvSkip.postDelayed(runnable, 2000);

        mTvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMain();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag = true;
        mTvSkip.removeCallbacks(runnable);
    }

    private synchronized void goMain() {
        if (!flag) {
            flag = true;
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }
    }
}
