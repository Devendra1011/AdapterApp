package com.example.adapterapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CursorAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listView = findViewById(R.id.list_view)


        var operatingSysytems = listOf("Windows", "Android", "IOS", "Macintosh", "Linux", "Unix", "BlackBerry")


        /*    val adapter = ArrayAdapter(this, R.layout.list_item_layout, operatingSysytems)
        listView.adapter = adapter
        */


        val customAdapter = MyCustomAdapter(this,operatingSysytems)
        listView.adapter = customAdapter


    }
}