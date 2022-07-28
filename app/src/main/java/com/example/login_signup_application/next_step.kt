package com.example.login_signup_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import java.util.jar.Attributes

class next_step : AppCompatActivity() {
    lateinit var textPersonName: EditText
    lateinit var textEmailAddress:EditText
    lateinit var phone:EditText
    lateinit var textPassword:EditText
    lateinit var etOtherName:EditText
    lateinit var male: RadioButton
    lateinit var female:RadioButton
    lateinit var other:RadioButton
    lateinit var Gender: RadioGroup
    lateinit var signup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_step)
        textPersonName=findViewById(R.id.TextPersonName2)
        textEmailAddress=findViewById(R.id.TextEmailAddress2)
        phone=findViewById(R.id.Phone)
        textPassword=findViewById(R.id.TextPassword)
        etOtherName=findViewById(R.id.etOtherName)
        male=findViewById(R.id.Male)
        female=findViewById(R.id.Female)
        other=findViewById(R.id.other)
        Gender=findViewById(R.id.Gender)
        signup=findViewById(R.id.signup)
        Gender.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.other->{
                    other.visibility= View.VISIBLE
                }

                else->{
                    other.visibility=View.INVISIBLE
                }
            }
        }
        signup.setOnClickListener {
            var name=textPersonName.text.toString()
            var email=textEmailAddress.text.toString()
            var No=phone.text.toString()
            var pass=textPassword.text.toString()
            var specify=other.text.toString()

            if (name.isNullOrEmpty()==true){
                textPersonName.error=resources.getString(R.string.please_enter_name)
                textPersonName.requestFocus()
            }
            else if(Patterns.EMAIL_ADDRESS.matcher(email).matches()==false){
               textEmailAddress.error=resources.getString(R.string.enter_valid_email)
                textEmailAddress.requestFocus()
            }
            else if (No.length<10){
                phone.error=resources.getString(R.string.enter_valid_number)
                phone.requestFocus()
            }
            else if(pass.isNullOrEmpty()==true){
                textPassword.error=resources.getString(R.string.enter_password)
                textPassword.requestFocus()
            }

            else if (other.visibility==View.VISIBLE && specify.isNullOrEmpty()==true){
                other.error=resources.getString(R.string.other)
               other.requestFocus()
            }
            else{
                Toast.makeText(this,R.string.signup_sucessfully,Toast.LENGTH_SHORT).show()
            }
        }
    }
}
