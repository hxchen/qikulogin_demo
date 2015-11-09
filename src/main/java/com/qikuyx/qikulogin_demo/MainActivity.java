package com.qikuyx.qikulogin_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.qikuyx.qikulogin.game.OnQikuLoginListener;
import com.qikuyx.qikulogin.game.QikuLoginSDK;


public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPlatformParams();
    }
    private void initPlatformParams() {

    }
    private void initView() {
        findViewById(R.id.btn_game_login).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_game_login:
                Log.i("QikuLogin_Demo", "点击游戏登录入口");
                QikuLoginSDK.getInstance().loginForGame(this, onQikuLoginListener);
                break;
            default:
                break;

        }
    }
    private OnQikuLoginListener onQikuLoginListener = new OnQikuLoginListener() {
        @Override
        public void onSuccess(String s) {
            Log.i("游戏Activity", "用户ID = " + s);
            Intent intent = new Intent(getBaseContext(), GameActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("userID", s);
            intent.putExtras(bundle);
            startActivity(intent);
        }

        @Override
        public void onFinish() {
            Log.i("游戏Activity", "用户关闭");
            Intent intent = new Intent(getBaseContext(), GameActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("userID", "用户关闭");
            intent.putExtras(bundle);
            startActivity(intent);
        }

        @Override
        public void onExit() {
            Log.i("游戏Activity", "用户退出 ");
            Intent intent = new Intent(getBaseContext(), GameActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("userID", "用户退出");
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };
}
