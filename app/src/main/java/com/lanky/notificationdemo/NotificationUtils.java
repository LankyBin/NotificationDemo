package com.lanky.notificationdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.provider.Settings;

import androidx.annotation.RequiresApi;

import static android.app.Notification.BADGE_ICON_SMALL;

/**
 * LankyBin create on 2020/11/3
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public class NotificationUtils {
    private NotificationManager mNotificationManager;
    private Context mContext;

    private static NotificationUtils mNotificationUtils = null;

    public NotificationUtils(Context context) {
        mContext = context;
        createGroup();
    }

    public static NotificationUtils getInstance(Context context) {
        if (mNotificationUtils == null) {
            mNotificationUtils = new NotificationUtils(context);
        }
        return mNotificationUtils;
    }

    private String ImportantGroupId = "ImportantGroupId";
    private CharSequence ImportantGroupName = "此应用的重要通知组";

    private String UnimportantGroupId = "UnimportantGroupId";
    private CharSequence UnimportantGroupName = "此应用的不重要通知组";

    private String ImportantChannelId = "ImportantChannelId";
    private String ImportantChannelName = "重要通知";
    private String ImportantChannelDesc = "请注意，这是重要的通知组,不建议关闭";
    private int ImportantChannelImportance = NotificationManager.IMPORTANCE_MAX;

    private String UnimportantChannelId = "UnimportantChannelId";
    private String UnimportantChannelName = "不重要的通知";
    private String UnimportantChannelDesc = "这是不重要的通知组，可以忽略";
    private int UnimportantChannelImportance = NotificationManager.IMPORTANCE_LOW;

    public void showImportantNotification() {
        createNotificationChannel(ImportantChannelId, ImportantChannelName, ImportantChannelImportance, ImportantChannelDesc, ImportantGroupId);

        Notification.Builder builder;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            builder = new Notification.Builder(mContext, ImportantChannelId);
            builder.setSmallIcon(R.mipmap.high_importance)
                    .setContentTitle("我是标题")
                    .setContentText("内容：这是一条Android8.0重要通知")
                    .setBadgeIconType(BADGE_ICON_SMALL)
                    .setNumber(1)
                    .setAutoCancel(true);
            Intent resultIntent = new Intent(mContext, MainActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(mContext);
            stackBuilder.addParentStack(MainActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(resultPendingIntent);
            mNotificationManager.notify((int) System.currentTimeMillis(), builder.build());
        }

    }

    public void showUnimportantNotification() {
        createNotificationChannel(UnimportantChannelId, UnimportantChannelName, UnimportantChannelImportance, UnimportantChannelDesc, UnimportantGroupId);

        Notification.Builder builder;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            builder = new Notification.Builder(mContext, UnimportantChannelId);
            builder.setSmallIcon(R.mipmap.low_importance)
                    .setContentTitle("我是小标题")
                    .setContentText("内容：这是一条Android8.0不重要通知")
                    .setBadgeIconType(BADGE_ICON_SMALL)
                    .setNumber(1)
                    .setAutoCancel(true);

            Intent resultIntent = new Intent(mContext, MainActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(mContext);
            stackBuilder.addParentStack(MainActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(resultPendingIntent);
            mNotificationManager.notify((int) System.currentTimeMillis(), builder.build());
        }

    }

    public void createNotificationChannel(String id, String name, int importance, String desc, String groupId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (mNotificationManager.getNotificationChannel(id) != null) {
                return;
            }

            NotificationChannel notificationChannel = new NotificationChannel(id, name, importance);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);

            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            notificationChannel.setShowBadge(true);
            notificationChannel.setBypassDnd(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400});
            notificationChannel.setDescription(desc);
            notificationChannel.setGroup(groupId);
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void delImportantNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mNotificationManager.deleteNotificationChannel(ImportantChannelId);
        }
    }

    public void delUnimportantNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mNotificationManager.deleteNotificationChannel(UnimportantChannelId);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void toImportantNotificationSetting() {
        Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
        intent.putExtra(Settings.EXTRA_CHANNEL_ID, ImportantChannelId);
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, mContext.getPackageName());
        mContext.startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void toUnimportantNotificationSetting() {
        Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
        intent.putExtra(Settings.EXTRA_CHANNEL_ID, UnimportantChannelId);
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, mContext.getPackageName());
        mContext.startActivity(intent);
    }

    public void createGroup() {
        mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mNotificationManager.createNotificationChannelGroup(new NotificationChannelGroup(ImportantGroupId, ImportantGroupName));
            mNotificationManager.createNotificationChannelGroup(new NotificationChannelGroup(UnimportantGroupId, UnimportantGroupName));
        }
    }

    public void delNotificationGroup() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mNotificationManager.deleteNotificationChannelGroup(UnimportantGroupId);
        }
    }
}
