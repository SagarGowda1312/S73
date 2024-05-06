package com.example.s7

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

/**
 * A simple Activity that shows a message.
 */
class New1Activity : Activity() {

    companion object {
        // The name of the extra data sent through an Intent.
        const val KEY_EXTRA_MESSAGE = "com.example.android.testing.espresso.basicsample.MESSAGE"

        fun newStartIntent(context: Context, message: String): Intent {
            val intent = Intent(context, New1Activity::class.java)
            intent.putExtra(KEY_EXTRA_MESSAGE, message)
            return intent
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new1)

        // Get the message from the Intent.
        val intent = intent
        val message = intent.getStringExtra(KEY_EXTRA_MESSAGE) ?: ""

        // Show message.
        findViewById<TextView>(R.id.textView2).text = message


        val btn=findViewById<Button>(R.id.call_btn)

        btn.setOnClickListener{
            val hasCallPhonePermission = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED

            if (hasCallPhonePermission) startActivity(createCallIntentFromNumber()) else Toast.makeText(
                this,
                "Grantttttttt permissssssssssion",
                Toast.LENGTH_SHORT
            ).show()

        }

        val btn2=findViewById<Button>(R.id.button_pick_contact)

        btn2.setOnClickListener{

            val intent2 = Intent(this@New1Activity, New2Activity::class.java)
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent2)
        }



        val btn3=findViewById<Button>(R.id.button_pick_contact2)

        btn3.setOnClickListener{

            val intent2 = Intent(this@New1Activity, New3Activity::class.java)
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent2)
        }
    }

    private fun createCallIntentFromNumber(): Intent {
        val intentToCall = Intent(Intent.ACTION_CALL)
        val number = findViewById<TextView>(R.id.textView2).text.toString()
        intentToCall.data = Uri.parse("tel:$number")
        return intentToCall
    }


}
