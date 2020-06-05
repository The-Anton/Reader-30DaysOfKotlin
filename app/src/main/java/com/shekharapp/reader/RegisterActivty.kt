package com.shekharapp.reader;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_register_activty.*

class RegisterActivty : AppCompatActivity() {


    val mDatabaseRef = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_activty)


        val auth = FirebaseAuth.getInstance()

        registerbtn_register.setOnClickListener {
            Toast.makeText(
                this,
                "Please Wait...",
                Toast.LENGTH_SHORT
            ).show()
            performRegister()

        }



    }


    private fun performRegister() {

        val email = email_register.text.toString()
        val password = password_register.text.toString()
        val cnfPassword = cnf_password_register.text.toString()

        if (password == cnfPassword) {
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter credentials", Toast.LENGTH_SHORT).show()
                return
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) {
                        Toast.makeText(
                            this,
                            "Please Try again !!!! or User already registered",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@addOnCompleteListener
                    } else {
                        Log.d(
                            "Main",
                            "Account created successfully with uid : $(it.result.user.uid)"
                        )
                        saveUserToFirebaseDatabase()


                        val intent = Intent(this, LogInActivty::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)

                    }


                }
                .addOnFailureListener {
                    Log.d("Main", "Failed to create account : $(it.message)")
                }
        } else {
            Toast.makeText(
                this,
                "Password didn't matched ",
                Toast.LENGTH_SHORT
            ).show()

        }
    }




    private fun saveUserToFirebaseDatabase() {

        val uid= fetchUserUid()
        val dbRef = mDatabaseRef.collection("user").document(uid.toString())
        val firstname = firstname_register.text.toString()
        val lastname = lastname_register.text.toString()
        val phonenumber = phone_register.text.toString()

        dbRef.update("firstName", firstname)
        dbRef.update("lastName", lastname)





    }



    private fun fetchUserUid(): String? {
        val user = FirebaseAuth.getInstance().currentUser
        val uid = user?.uid
        return uid
    }
}