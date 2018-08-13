# qikulogin_demo
奇酷工场登陆SDK演示Demo,主要是调用接口加载SDK登陆界面和SDK回调游戏通知2个功能。

## 1、SDK下载

代码下载地址:<a href="https://github.com/hxchen/qikulogin_demo/blob/master/libs/" target="_blank">点此下载进入下载页</a>


资源下载:(下载整个res目录放到游戏工程里进行编译)<a href="https://github.com/hxchen/qikulogin_demo/tree/master/src/main/res" target="_blank">点此下载进入下载页</a>

## 2、配置

### 2.1 <a href="https://github.com/hxchen/qikulogin_demo/blob/master/build.gradle" target="_blank">build.gradle</a>
---------------------
引入相应的依赖包:
```
    implementation 'com.android.support:appcompat-v7:26.1.0'
    implementation 'com.google.android.gms:play-services:10.2.1'
    implementation 'com.fasterxml.jackson.core:jackson-databind:2.2.+'
    implementation 'com.google.code.gson:gson:2.2.4'
    implementation 'commons-httpclient:commons-httpclient:3.1'
    implementation 'org.springframework.android:spring-android-rest-template:2.0.0.M1'
    implementation 'com.google.android.gms:play-services-ads:10.2.1'
    implementation 'com.google.android.gms:play-services-auth:10.2.1'
    implementation 'com.google.android.gms:play-services-gcm:10.2.1'
```
### 2.2 <a href="https://github.com/hxchen/qikulogin_demo/blob/master/src/main/AndroidManifest.xml" target="_blank">AndroidManifest.xml</a>
---------------------
### 2.2.1 添加相应的权限
```
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"></uses-permission>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
<uses-permission android:name="android.permission.INTERNET"></uses-permission>
```
### 2.2.2 添加Activity声明
```
<activity android:name="com.qikuyx.qikulogin.activity.MainActivity"></activity>
<activity android:name="com.qikuyx.qikulogin.activity.QikuLoginActivity"></activity>
<activity android:name="com.qikuyx.qikulogin.activity.QikuInputAccountActivity"></activity>
<activity android:name="com.qikuyx.qikulogin.activity.QikuSetUserInfoActivity"></activity>
<activity android:name="com.qikuyx.qikulogin.activity.QikuForgetPasswordActivity"></activity>
<activity android:name="com.qikuyx.qikulogin.activity.QikuForgetPasswordValidateActivity"></activity>
<activity android:name="com.qikuyx.qikulogin.activity.QikuForgetPasswordSetActivity"></activity>
<activity android:name="com.qikuyx.qikulogin.activity.QikuRecoveryTemproraryAccountActivity"></activity>
<activity android:name="com.qikuyx.qikulogin.activity.QikuSelectAccountActivity"></activity>
<activity android:name="com.qikuyx.qikulogin.activity.QikuBindingInputAccountActivity"></activity>
<activity android:name="com.qikuyx.qikulogin.activity.QikuBindingValidateActivity"></activity>
<activity android:name="com.qikuyx.qikulogin.activity.QikuBindingSetUserInfoActivity"></activity>
```
### 2.2.3 添加google_play_services_version
```
<meta-data android:name="com.google.android.gms.version" android:value="@integer/google_play_services_version" />
```
## 2.3 <a href="https://github.com/hxchen/qikulogin_demo/blob/master/src/main/java/com/qikuyx/qikulogin_demo/MainActivity.java" target="_blank">交互</a>
---------------------
### 2.3.1调用接口加载登陆显示界面
```Java
QikuLoginSDK.getInstance().loginForGame(Content content, OnQikuLoginListener onQikuLoginListener);
```
### 2.3.2回调游戏接口

```Java
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
```
