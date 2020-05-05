package com.example.topnews.countries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.topnews.R
import com.example.topnews.breakingnews.BreakingNewsFragment

class CountriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        val fragment = CountriesFragment()
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        if (savedInstanceState == null) {
            ft.add(R.id.fl_container, fragment)
                .commit()
        }
    }
}
