package com.muzafferatmaca.instaclone.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.muzafferatmaca.instaclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    var email : String? = null
    var password : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = Firebase.auth

        // If the user is logged in, it goes directly to the feed screen
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null){
            val intent = Intent(this, FeedActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    fun signInClicked(view: View) {

        email = binding.emailEditText.text.toString()
        password = binding.passwordEditText.text.toString()
        if (email.equals("") || password.equals("")){

            Toast.makeText(this, "enter email and password", Toast.LENGTH_LONG).show()

        }else{

            firebaseAuth.signInWithEmailAndPassword(email!!, password!!).addOnSuccessListener {

                val intent = Intent(this@MainActivity, FeedActivity::class.java)
                startActivity(intent)
                finish()

            }.addOnFailureListener {

                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
            }

        }

    }

    fun sigUpClicked(view: View) {

         email = binding.emailEditText.text.toString()
         password = binding.passwordEditText.text.toString()
        if (email.equals("") || password.equals("")) {

            Toast.makeText(this, "enter email and password", Toast.LENGTH_LONG).show()

        } else {
            firebaseAuth.createUserWithEmailAndPassword(email!!, password!!).addOnSuccessListener {
                //success

                val intent = Intent(this@MainActivity, FeedActivity::class.java)
                startActivity(intent)
                finish()

            }.addOnFailureListener {

                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
            }

        }



    }
}