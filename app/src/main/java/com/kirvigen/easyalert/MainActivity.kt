package com.kirvigen.easyalert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kirvigen.easyalertlibrary.EasyAlert
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.editText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simple.setOnClickListener {
            EasyAlert(this).setTitle("Warning!").setTextBody("Your is beautiful")
                .setNeutral("Ok",
                    {a->a.dismiss()},
                    resources.getColor(R.color.Blue))
                .show()
        }
        buttons.setOnClickListener {
            EasyAlert(this).setTitle("Warning!").setTextBody("Your is beautiful")
                .setPositive("Yes!") { a-> a.dismiss()}
                .setNegative("No!"){a->a.dismiss()}
                .setNeutral("Cancel",{a->a.dismiss()})
                .show()
        }
        imageRes.setOnClickListener {
            EasyAlert(this).setTopImage(R.drawable.image)
                .setTitle("Warning!").setTextBody("Your is beautiful")
                .setPositive("Yes!") { a-> a.dismiss()}
                .setNegative("No!"){a->a.dismiss()}
                .setNeutral("Cancel",{a->a.dismiss()})
                .show()
        }
        imageUrl.setOnClickListener {
            EasyAlert(this).setTopImage("https://avatars.mds.yandex.net/get-pdb/1964870/f271cd11-8868-4bcd-93e7-e911d2254a90/s1200")
                .setTitle("Warning!").setTextBody("Your is beautiful")
                .setPositive("Yes!") { a-> a.dismiss()}
                .setNegative("No!"){a->a.dismiss()}
                .setNeutral("Cancel",{a->a.dismiss()})
                .show()
        }
        editText.setOnClickListener {
            EasyAlert(this)
                .setTitle("Warning!").setTextBody("Please enter your Name")
                .setEditText("Name")
                .setPositive("Send") { a-> a.dismiss()
                        Toast.makeText(this,"Your Name is \"${a.inputText}\"",Toast.LENGTH_LONG).show()
                }
                .setNeutral("Cancel",{a->a.dismiss()})
                .show()
        }
        listItem.setOnClickListener {
            val colors = arrayOf("Red","Green","Blue")
            EasyAlert(this)
                .setTitle("Choose").setTextBody("Do choose your favorite color")
                .setListItems(colors){a,position->
                    a.dismiss()
                    Toast.makeText(this,colors[position],Toast.LENGTH_LONG).show()
                }
                .setNeutral("Cancel",{a->a.dismiss()})
                .show()
        }
        combination.setOnClickListener {
            EasyAlert(this)
                .setTopImage(R.drawable.image)
                .setTitle("This is combination!").setTextBody("Please enter your Name")
                .setEditText("Name")
                .setPositive("Send") { a-> a.dismiss()
                    Toast.makeText(this,"Your Name is \"${a.inputText}\"",Toast.LENGTH_LONG).show()
                }
                .setNegative("I don`t enter my name"){
                    a->a.dismiss()
                }
                .setNeutral("Cancel",{a->a.dismiss()})
                .show()
        }
    }
}