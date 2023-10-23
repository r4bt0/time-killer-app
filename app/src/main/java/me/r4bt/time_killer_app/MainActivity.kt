package me.r4bt.time_killer_app

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var counter = 0

        val counterView = findViewById<TextView>(R.id.st)
        val btn = findViewById<ImageButton>(R.id.button)
        btn.setOnClickListener {
            counter += 1
            counterView.text = getString(R.string.counter_label, counter)
            val params = it.layoutParams as LayoutParams
            params.horizontalBias = Random.nextFloat()
            params.verticalBias = Random.nextFloat()
            it.layoutParams = params
        }
    }
}