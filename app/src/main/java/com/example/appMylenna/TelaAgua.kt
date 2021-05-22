package com.example.appMylenna

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.tela_agua.*
import java.text.SimpleDateFormat
import java.util.*

class TelaAgua : AppCompatActivity() {

    private var PRIVATE_MODE = 0
    private val PREF_NAME = "mylenna_app"
    private val KEY_COUNT = "count_water"
    private val KEY_DAY = "day_saved"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_agua)

        val sharedPref: SharedPreferences = getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        var countWaterSaved = sharedPref.getInt(KEY_COUNT, 0)
        var date = sharedPref.getString(KEY_DAY, "")
        val editor = sharedPref.edit()

        val day = Calendar.getInstance().time
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val dayFormatted = sdf.format(day)

        if(date != dayFormatted){
            countWaterSaved = 0
            editor.putInt(KEY_COUNT, 0)
            editor.putString(KEY_DAY, dayFormatted)
            editor.apply()
        }

        numeroAgua.text = countWaterSaved.toString()

        llButtonWater.setOnClickListener {
            countWaterSaved += 1
            numeroAgua.text = countWaterSaved.toString()
            editor.putInt(KEY_COUNT, countWaterSaved)
            editor.apply()
        }

    }

}