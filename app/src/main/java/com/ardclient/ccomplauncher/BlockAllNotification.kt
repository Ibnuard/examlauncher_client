package com.ardclient.ccomplauncher

import android.content.Intent
import android.os.IBinder
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log


class BlockAllNotification : NotificationListenerService() {
    override fun onBind(intent: Intent): IBinder? {
        return super.onBind(intent)
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) { // Implement what you want here
// Inform the notification manager about dismissal of all notifications.
        Log.d("Msg", "Notification arrived")
        cancelAllNotifications()
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) { // Implement what you want here
        Log.d("Msg", "Notification Removed")
    }
}