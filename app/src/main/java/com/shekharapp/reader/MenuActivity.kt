package com.shekharapp.reader;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val offlineBooksList = arrayOf("70 Amazing Facts About Your Brain", "BRAIN TEASERS", "Improving Your Memory","Making Robots With The Arduino", "Teach Yourself Electricity and Electronics","Fundamentals of Rocket Motors")
        val adapter = ArrayAdapter<String>(this ,R.layout.offline_book_list,offlineBooksList)

        val listView:ListView = findViewById(R.id.offlineContentListView)
        listView.adapter = adapter


        listView.setOnItemClickListener{parent, view, position, id ->


            if (position==0){
                val intent =  Intent(this, ReaderActivty::class.java)
                intent.putExtra("BookName", "brain_facts")
                intent.putExtra("Mode", "0")
                startActivity(intent)
            }
            if (position==1){
                val intent =  Intent(this, ReaderActivty::class.java)
                intent.putExtra("BookName", "brainteasers")
                intent.putExtra("Mode", "0")
                startActivity(intent)
            }
            if (position==2){
                val intent =  Intent(this, ReaderActivty::class.java)
                intent.putExtra("BookName", "ImprovingMemory")
                intent.putExtra("Mode", "0")
                startActivity(intent)
            }
            if (position==3){
                val intent =  Intent(this, ReaderActivty::class.java)
                intent.putExtra("BookName", "arduino_robot")
                intent.putExtra("Mode", "0")
                startActivity(intent)
            }
            if (position==4){
                val intent =  Intent(this, ReaderActivty::class.java)
                intent.putExtra("BookName", "Electricity")
                intent.putExtra("Mode", "0")
                startActivity(intent)
            }
            if (position==5){
                val intent =  Intent(this, ReaderActivty::class.java)
                intent.putExtra("BookName", "FundalRocketMotors")
                intent.putExtra("Mode", "0")
                startActivity(intent)
            }
        }
    }
}