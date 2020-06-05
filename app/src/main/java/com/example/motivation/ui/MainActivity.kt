package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.MotivationConstants.*
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splashscreen.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        emoction_all.setColorFilter(resources.getColor(R.color.colorAccent))
        handlerNewPhrase()

        mSecurityPreferences = SecurityPreferences(this)
        text_name.text  = mSecurityPreferences.getString(KEY.PERSON_NAME)

        btn_new_phrase.setOnClickListener(this)
        emoction_all.setOnClickListener(this)
        emoction_happy.setOnClickListener(this)
        emoction_sunny.setOnClickListener(this)

    }

    override fun onClick(v: View) {

        val listFilter = listOf(R.id.emoction_all, R.id.emoction_happy, R.id.emoction_sunny)

        if (v.id == R.id.btn_new_phrase) {
            handlerNewPhrase()
        } else if (v.id in listFilter){
            handlerFilter(v.id)
        }
    }

    private fun handlerFilter(id: Int){

        emoction_all.setColorFilter(resources.getColor(R.color.white))
        emoction_happy.setColorFilter(resources.getColor(R.color.white))
        emoction_sunny.setColorFilter(resources.getColor(R.color.white))

        when (id) {

            R.id.emoction_all -> {
                emoction_all.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL
            }

            R.id.emoction_happy -> {
                emoction_happy.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }

            R.id.emoction_sunny -> {
                emoction_sunny.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.SUNNY
            }

        }

    }

    private fun handlerNewPhrase(){

        phrase_motivation.text = Mock().getPhrase(mPhraseFilter)

    }
}
