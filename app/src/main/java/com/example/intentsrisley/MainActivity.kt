package com.example.intentsrisley

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var mbtnsms:Button
    lateinit var mbtnemail:Button
    lateinit var mbtncamera:Button
    lateinit var mbtnshare:Button
    lateinit var mbtnmpesa:Button
    lateinit var mbtncall:Button
    lateinit var mbtnwebsite:Button
    lateinit var mbtnmap:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mbtnwebsite = findViewById(R.id.btnwebsite)
        mbtnmap = findViewById(R.id.btnmap)
        mbtnsms = findViewById(R.id.btnsms)
        mbtnemail = findViewById(R.id.btnemail)
        mbtncamera = findViewById(R.id.btncamera)
        mbtnshare = findViewById(R.id.btnshare)
        mbtnmpesa = findViewById(R.id.btnmpesa)
        mbtncall = findViewById(R.id.btncall)


       mbtnsms.setOnClickListener {
           var uri: Uri = Uri.parse("smsto:0792691002")
           var intent = Intent(Intent.ACTION_SENDTO,uri)
           intent.putExtra("sms_body", "City")
           startActivity(intent)

        }

        mbtnemail.setOnClickListener {
            var emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "risley@gmail.com", null ))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Sir, ....")
            startActivity(Intent.createChooser(emailIntent, "send Email"))


        }

        mbtncamera.setOnClickListener {
            var takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)


        }

        mbtnmpesa.setOnClickListener {
            var simToolKITIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKITIntent?.let { startActivity(it) }


        }


        mbtnwebsite.setOnClickListener {

            val gotoanotheractivity = Intent(this, WebsiteActivity::class.java)
            startActivity(gotoanotheractivity)


        }
    }
}