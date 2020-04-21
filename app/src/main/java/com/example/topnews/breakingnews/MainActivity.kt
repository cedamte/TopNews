package com.example.topnews.breakingnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.topnews.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = BreakingNewsFragment()
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        if (savedInstanceState == null) {
            ft.add(R.id.fl_container, fragment)
                .commit()
        }

    }
}
