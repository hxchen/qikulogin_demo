package com.qikuyx.qikulogin_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/3.
 */
public class GameActivity  extends Activity{
    TextView tvUuserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tvUuserID = (TextView) findViewById(R.id.tv_userid);
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        tvUuserID.setText(userID);
    }
}
