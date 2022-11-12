package com.waewaee.ww_custom_view_components.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.waewaee.ww_custom_view_components.R
import com.waewaee.ww_custom_view_components.veiws.components.EmotionalFaceView
import kotlinx.android.synthetic.main.activity_custom_component.*

class CustomComponentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_component)

        // 1
        happyButton.setOnClickListener {
            emotionalFaceView.happinessState = EmotionalFaceView.HAPPY
        }

        // 2
        sadButton.setOnClickListener {
            emotionalFaceView.happinessState = EmotionalFaceView.SAD
        }

        btnNavigate.setOnClickListener {
            startActivity(FanControlActivity.newIntent(this))
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CustomComponentActivity::class.java)
        }
    }
}