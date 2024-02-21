package com.example.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countries.databinding.ActivityMainBinding
import com.example.countries.view.CountriesFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.mainfragmentcontainer.id, CountriesFragment.newInstance())
            .commit()
    }
}