package com.example.scheduleapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val username = intent.getStringExtra("USERNAME")
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = "Здравствуйте, $username!"

        // Автоматический переход через 3 секунды
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ScheduleActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3000 миллисекунд = 3 секунды
    }
}
