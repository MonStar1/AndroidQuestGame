package com.andreip.androidquestgame

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.andreip.androidquestgame.util.hideAppIcon
import com.andreip.androidquestgame.util.showAppIcon
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_registration.*

private const val RC_SIGN_IN = 123

class RegistrationActivity : Activity() {
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val currentUser = auth.currentUser

        if (currentUser != null) {
//            username.text = currentUser.email

            val refreshedToken = FirebaseInstanceId.getInstance().token

            token.text = refreshedToken

            Log.d(RegistrationActivity::class.java.simpleName, "Refreshed token: $refreshedToken")

            registered()
        } else {
            startActivityForResult(
                    AuthUI.getInstance().createSignInIntentBuilder().build(),
                    RC_SIGN_IN
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == RESULT_OK) {
//                username.text = auth.currentUser?.email
                registered()
            } else {
                username.text = response?.error?.errorCode.toString()
            }
        }
    }

    private fun registered() {
        FirebaseMessaging.getInstance().subscribeToTopic("quest")

        if (questStatePref.questStarted) {
            showAppIcon(RegistrationActivity::class.java)
            startActivity(Intent(this, QuestActivity::class.java))
            finish()
        } else {
            hideAppIcon(RegistrationActivity::class.java)
        }
    }
}