package com.beginning.attirare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Patterns
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*

class Auth : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        initFirebaseAuth()

        btnSignIn.setOnClickListener{
            val email = Email.text.toString().trim()
            val password = Password.text.toString().trim()

            if(checkValidation(email,password)) {
                loginToServer(email,password)
            }
        }

        btn_google_signin.setOnClickListener {

        }

    }

    private fun firebaseAuth(credential: AuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finishAffinity()
                } else {
                    Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener{ exception ->
                Toast.makeText(this,exception.message,Toast.LENGTH_SHORT).show()
            }
    }

    private fun loginToServer(email: String, password: String) {
        val credential = EmailAuthProvider.getCredential(email,password)
        firebaseAuth(credential)
    }

    private fun checkValidation(email: String, password: String): Boolean {

        if (email.isEmpty()) {
            Email.error="Please enter an email"
            Email.requestFocus()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.error="Please enter a valid email"
            Email.requestFocus()
        } else if (password.isEmpty()) {
            Password.error="Please enter your password"
            Password.requestFocus()
        } else {
            return true
        }

        return false
    }

    private fun initFirebaseAuth() {
        auth = FirebaseAuth.getInstance()
    }
}