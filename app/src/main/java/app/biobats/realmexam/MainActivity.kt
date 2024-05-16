package app.biobats.realmexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import io.realm.kotlin.where

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RealmObject.realm.addChangeListener {
            findViewById<TextView>(R.id.textView).text = it.where<UserModel>().findAll().asJSON()
        }

        findViewById<Button>(R.id.getAllBtn).setOnClickListener {
            findViewById<TextView>(R.id.textView).text = RealmObject.getAllUsers().asJSON()
        }

        findViewById<Button>(R.id.insertOrUpdateBtn).setOnClickListener {
            val name = findViewById<EditText>(R.id.nameEt).text.toString()
            val age = findViewById<EditText>(R.id.ageEt).text.toString().toInt()

            RealmObject.insert(UserModel(name, age))
        }

        findViewById<Button>(R.id.deleteAllBtn).setOnClickListener {
            RealmObject.deleteAllUsers()
        }

        findViewById<Button>(R.id.deleteByIdBtn).setOnClickListener {
            RealmObject.deleteUserByName(findViewById<EditText>(R.id.deleteIdEt).text.toString())
        }

        findViewById<Button>(R.id.getUserByIdBtn).setOnClickListener {
            RealmObject.getUserByName(findViewById<EditText>(R.id.deleteIdEt).text.toString())
        }
    }
}