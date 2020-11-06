# NotificationDemo
NotificationDemo on Android8.0

Androidstudio4.x is recommended.

[APK DEMO](https://github.com/LankyBin/NotificationDemo/raw/main/APK_Demo/NotificationDemo_Androido.apk)
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
# Results show
<div align=center><img src="https://github.com/LankyBin/NotificationDemo/blob/main/raw/20201106164605.png" width="300" height="550" ><div>
<div align=center><img src="https://github.com/LankyBin/NotificationDemo/blob/main/raw/20201106164804.png" width="300" height="550" ><div>
<div align=center><img src="https://github.com/LankyBin/NotificationDemo/blob/main/raw/20201106164922.png" width="300" height="550" ><div>
<div align=center><img src="https://github.com/LankyBin/NotificationDemo/blob/main/raw/20201106164931.png" width="300" height="550" ><div>
<div align=center><img src="https://github.com/LankyBin/NotificationDemo/blob/main/raw/20201106164940.png" width="300" height="550" ><div>
