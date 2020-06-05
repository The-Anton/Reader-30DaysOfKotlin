package com.shekharapp.reader;

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val offlineBooksList = arrayOf("70 Amazing Facts About Your Brain", "BRAIN TEASERS", "Improving Your Memory","Making Robots With The Arduino", "Teach Yourself Electricity and Electronics","Fundamentals of Rocket Motors")
        val adapter = ArrayAdapter<String>(this ,R.layout.offline_book_list,offlineBooksList)

        val listView:ListView = findViewById(R.id.offlineContentListView)
        listView.adapter = adapter



        listView.setOnItemClickListener{parent, view, position, id ->


            val bookName = when(position){

                0->"brain_facts"
                2->"brainteasers"
                3->"ImprovingMemory"
                4->"arduino_robot"
                5->"Electricity"
                6->"FundalRocketMotors"
                else -> null
            }

                val intent =  Intent(this, ReaderActivty::class.java)
                intent.putExtra("BookName", "${bookName}")
                intent.putExtra("Mode", "0")
                startActivity(intent)

        }
    }


}