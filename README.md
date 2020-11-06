# NotificationDemo
NotificationDemo on Android8.0

Androidstudio4.x is recommended.
# Contains a utility class named NotificationUtils
Use demo:

```
        switch (v.getId()) {
            case R.id.btn_send_important_notification:
                NotificationUtils.getInstance(MainActivity.this).showImportantNotification();
                break;
            case R.id.btn_del_important_notification:
                NotificationUtils.getInstance(MainActivity.this).delImportantNotification();
                break;
            case R.id.btn_send_unimprotant_notification:
                NotificationUtils.getInstance(MainActivity.this).showUnimportantNotification();
                break;
            case R.id.btn_del_unimportant_notification:
                NotificationUtils.getInstance(MainActivity.this).delUnimportantNotification();
                break;
            case R.id.btn_important_notification_setting:
                NotificationUtils.getInstance(MainActivity.this).toImportantNotificationSetting();
                break;
            case R.id.btn_unimportant_notification_setting:
                NotificationUtils.getInstance(MainActivity.this).toUnimportantNotificationSetting();
                break;
            default:
                break;
        }
```
