package com.orange.internship.notificationsproofofconcept.services;

import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MainFirebaseMessagingService : FirebaseMessagingService() {

    private val TAG = "FCM.SERVICE"

    override fun onNewToken(token: String) {
        Log.d(TAG, "New Token Received: $token")
    }

}

class SpecialFirebaseMessagingService : FirebaseMessagingService(){
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        p0.notification.let {
            val notification = NotificationCompat.Builder(this)
                .setContentTitle(p0.from)
                .setContentText(it?.body)
                .build()

            val manager = NotificationManagerCompat.from(applicationContext)
            manager.notify(0, notification)
        }
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
    }
}
