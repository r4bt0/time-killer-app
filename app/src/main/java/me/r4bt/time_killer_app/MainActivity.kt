package me.r4bt.time_killer_app

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counterView = findViewById<TextView>(R.id.st)
        val btn = findViewById<ImageButton>(R.id.button)

        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.count.observe(this) {
            counterView.text = getString(R.string.counter_label, it)
        }

        btn.setOnClickListener {
            it.apply {
                val params = layoutParams as LayoutParams
                params.apply {
                 horizontalBias = Random.nextFloat()
                 verticalBias = Random.nextFloat()
                }
                layoutParams = params
            }
            mainViewModel.incrementCounter()
        }
    }
}