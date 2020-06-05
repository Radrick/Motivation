package com.example.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splashscreen.*

class SplashscreenActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        btn_save.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_save){
            handleSave()
        }
    }

    private fun handleSave(){
        if(fText_name.text.toString().isNotEmpty()){
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, R.string.empty_field_name, Toast.LENGTH_SHORT).show()
        }
    }
}