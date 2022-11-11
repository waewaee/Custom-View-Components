package com.waewaee.ww_custom_view_components.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.waewaee.ww_custom_view_components.R

class CustomComponentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_component)

    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CustomComponentActivity::class.java)
        }
    }
}