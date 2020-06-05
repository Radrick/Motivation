package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splashscreen.*

class SplashscreenActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        mSecurityPreferences =  SecurityPreferences(this)

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

        var name = fText_name.text.toString()

        if(name.isNotEmpty()){
            mSecurityPreferences.storeString("name", name)
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this,
                R.string.empty_field_name, Toast.LENGTH_SHORT).show()
        }
    }
}