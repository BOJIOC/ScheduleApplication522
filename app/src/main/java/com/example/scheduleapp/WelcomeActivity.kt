package com.example.scheduleapp

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val username = intent.getStringExtra("USERNAME")
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val ivSun = findViewById<ImageView>(R.id.ivSun)

        tvWelcome.text = "Здравствуйте, $username"

        // Анимация солнца
        val translateX = PropertyValuesHolder.ofFloat("translationX", 300f)
        val translateY = PropertyValuesHolder.ofFloat("translationY", -300f)
        val rotation = PropertyValuesHolder.ofFloat("rotation", 0f, 360f)
        val sunAnimation = ObjectAnimator.ofPropertyValuesHolder(ivSun, translateX, translateY, rotation)
        sunAnimation.duration = 3000
        sunAnimation.start()

        // Автоматический переход через 3 секунды
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ScheduleActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3000 миллисекунд = 3 секунды
    }
}
