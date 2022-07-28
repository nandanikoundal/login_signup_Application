package com.example.login_signup_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var textPersonName: EditText
    lateinit var textPassword: EditText
    lateinit var login: Button
    lateinit var forgetpassword: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       textPersonName=findViewById(R.id.email)
        textPassword=findViewById(R.id.Password)
        login=findViewById(R.id.Login)
        forgetpassword=findViewById(R.id.forgetpassword)
        login.setOnClickListener{
            var name=textPersonName.text.toString()
            var Password=textPassword.text.toString()
            if(name.isNullOrEmpty()==true){
                textPersonName.error=resources.getString(R.string.please_enter_email)
                textPersonName.requestFocus()

            }
            else if(Password.isNullOrEmpty()==true){
               textPassword.error=resources.getString(R.string.please_enter_password)
                textPassword.requestFocus()
            }
            else if (Password.length<6){
                textPassword.error=resources.getString(R.string.password_length)
            }
            else {
                Toast.makeText(this, resources.getString(R.string.login_successfull), Toast.LENGTH_LONG).show()
            }
           forgetpassword.setOnClickListener {
                var intent2= Intent(this,forgetpassword::class.java)
                startActivity(intent2)
            }
        }

    }
}