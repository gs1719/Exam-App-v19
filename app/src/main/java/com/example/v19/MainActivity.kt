package com.example.v19

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import com.example.v19.Result
import com.example.v19.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    companion object {
        const val KEY = "com.example.v19.MainActivity.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        var totalMarksObtained = 0
        setContentView(binding.root)
        onBackPressedDispatcher.addCallback(this,onBackPressedCallback)


        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Linux is a ________ ?")
//            builder1.setMessage()
            val options = arrayOf("Operating System", "Kernel", "Penguin")
            builder1.setMultiChoiceItems(options, null,
                DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                    if(i==1) {
                        totalMarksObtained++
                        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                    }
                    else
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                })
            
            builder1.setPositiveButton("Submit") { dialogInterface, i -> }
            builder1.show()
        }
        binding.btn2.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Android is a ________ ?")
//            builder1.setMessage()
            val options = arrayOf("Operating System", "Kernel", "Penguin")
            builder1.setMultiChoiceItems(options, null,
                DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                    if(i==0) {
                        totalMarksObtained++
                        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                    }
                    else
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                })
            
            builder1.setPositiveButton("Submit") { dialogInterface, i -> }
            builder1.show()
        }
        binding.btn3.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("BIOS is a ________ ?")
//            builder1.setMessage()
            val options = arrayOf("Software", "Hardware", "Both")
            builder1.setMultiChoiceItems(options, null,
                DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                    if(i==2) {
                        totalMarksObtained++
                        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                    }
                    else
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                })
            
            builder1.setPositiveButton("Submit") { dialogInterface, i -> }
            builder1.show()
        }
        binding.btn4.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Android orignally made for ________ ?")
//            builder1.setMessage()
            val options = arrayOf("Mobile", "Laptop", "Camera", "NOne")
            builder1.setMultiChoiceItems(options, null,
                DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                    if(i==2) {
                        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                        totalMarksObtained++
                    }
                    else
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                })
            builder1.setCancelable(false)
            builder1.setPositiveButton("Submit") { dialogInterface, i -> }
            builder1.show()
        }

        binding.btn5.setOnClickListener {
            intent = Intent(this,Result::class.java).apply {
                putExtra(KEY,totalMarksObtained.toString())
            }
            startActivity(intent)
        }
    }
    private val onBackPressedCallback:OnBackPressedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            MaterialAlertDialogBuilder(this@MainActivity)
                .setTitle("Warning")
                .setMessage("Do you really want to close the app?")
                .setPositiveButton("Yes") { _, _ -> finish() }
                .setNegativeButton("No", null)
                .show()
        }
    }
}
