package com.lanky.notificationdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MainActivity extends Activity implements View.OnClickListener {

    NotificationUtils notificationUtils;

    //Android 0
    private Button btn_send_important_notification;
    private Button btn_del_important_notification;
    private Button btn_send_unimprotant_notification;
    private Button btn_del_unimportant_notification;
    private Button btn_important_notification_setting;
    private Button btn_unimportant_notification_setting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_send_important_notification = findViewById(R.id.btn_send_important_notification);
        btn_del_important_notification = findViewById(R.id.btn_del_important_notification);
        btn_send_unimprotant_notification = findViewById(R.id.btn_send_unimprotant_notification);
        btn_del_unimportant_notification = findViewById(R.id.btn_del_unimportant_notification);
        btn_important_notification_setting = findViewById(R.id.btn_important_notification_setting);
        btn_unimportant_notification_setting = findViewById(R.id.btn_unimportant_notification_setting);
        btn_send_important_notification.setOnClickListener(this);
        btn_del_important_notification.setOnClickListener(this);
        btn_send_unimprotant_notification.setOnClickListener(this);
        btn_del_unimportant_notification.setOnClickListener(this);
        btn_important_notification_setting.setOnClickListener(this);
        btn_unimportant_notification_setting.setOnClickListener(this);
        notificationUtils = new NotificationUtils(MainActivity.this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_important_notification:
                notificationUtils.showImportantNotification();
                break;
            case R.id.btn_del_important_notification:
                notificationUtils.delImportantNotification();
                break;
            case R.id.btn_send_unimprotant_notification:
                notificationUtils.showUnimportantNotification();
                break;
            case R.id.btn_del_unimportant_notification:
                notificationUtils.delUnimportantNotification();
                break;
            case R.id.btn_important_notification_setting:
                notificationUtils.toImportantNotificationSetting();
                break;
                case R.id.btn_unimportant_notification_setting:
                notificationUtils.toUnimportantNotificationSetting();
                break;
            default:
                break;
        }
    }

}