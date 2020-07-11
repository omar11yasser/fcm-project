package com.orange.internship.notificationsproofofconcept.UI

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.orange.internship.notificationsproofofconcept.R

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val fcmId = FirebaseInstanceId.getInstance().instanceId

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fcmId.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "getInstanceId failed", task.exception)
                return@OnCompleteListener
            }

            val token = task.result?.token!!
            Toast.makeText(this, token, Toast.LENGTH_SHORT).show()
            Log.d(TAG, "Token Received: $token")
        })
    }

}