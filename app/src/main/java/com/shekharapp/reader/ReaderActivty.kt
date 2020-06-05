package com.shekharapp.reader;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reader_activty.*

class ReaderActivty : AppCompatActivity() {

    private lateinit var bookName :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reader_activty)

        val intent = intent
        bookName = intent.getStringExtra("BookName")
        val mode = intent.getStringExtra("Mode")


        if (mode == "1"){
            loadFromInternet()
        }else{
            loadFromStorage()

        }
    }

    private fun loadFromStorage() {
        pdfView.fromAsset("${bookName}.pdf").load()

    }

    private fun loadFromInternet() {
        TODO("Not yet implemented")
    }
}