package com.afkoders.batteryme.fcm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


/**
 * Created by Kalevych Oleksandr on 2020-01-09.
 */

class BatteryFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        showNotification(remoteMessage.notification)
    }

    private fun showNotification(data: RemoteMessage.Notification?) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val mBuilder = NotificationCompat.Builder(applicationContext, DEFAULT_CHANNEL_ID)
        val ii = Intent(applicationContext, MainActivity::class.java)
        val pendingIntent =
            PendingIntent.getActivity(applicationContext, 0, ii, PendingIntent.FLAG_UPDATE_CURRENT)

        mBuilder.apply {
            setContentIntent(pendingIntent)
            setSmallIcon(R.mipmap.ic_launcher_round)
            setContentTitle(data?.title)
            setContentText(data?.body)
            priority = Notification.PRIORITY_MAX

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channelId = ARTIFICIAL_CHANNEL_ID
                val channel = NotificationChannel(
                    channelId,
                    data?.title,
                    NotificationManager.IMPORTANCE_HIGH
                )
                notificationManager.createNotificationChannel(channel)
                setChannelId(channelId)
            }
        }
        notificationManager.notify(0, mBuilder.build())
    }

    companion object {
        const val DEFAULT_CHANNEL_ID = "notify_001"
        const val ARTIFICIAL_CHANNEL_ID = "Your_channel_id"
    }
}

