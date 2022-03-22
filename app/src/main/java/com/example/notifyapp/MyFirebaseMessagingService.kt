package com.example.notifyapp;

import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

        override fun onMessageReceived(remoteMessage: RemoteMessage) {
                super.onMessageReceived(remoteMessage)
                getFirebaseMessage(remoteMessage.notification?.title.toString(), remoteMessage.notification?.body.toString())
        }

        fun getFirebaseMessage(title: String, msg : String){
                val builder = NotificationCompat.Builder(this, "MyNewChannel")
                        .setSmallIcon(R.drawable.ic_notify)
                        .setContentText(msg)
                        .setContentTitle(title)
                        .setAutoCancel(true)

                val manager = NotificationManagerCompat.from(this)
                manager.notify(101,builder.build())
        }

}
