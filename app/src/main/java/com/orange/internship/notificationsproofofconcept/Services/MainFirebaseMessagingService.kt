package com.orange.internship.notificationsproofofconcept.Services;

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class MainFirebaseMessagingService : FirebaseMessagingService() {

    private val TAG = "FCM.SERVICE"

    override fun onNewToken(token: String) {
        Log.d(TAG, "New Token Received: $token")
    }

}
