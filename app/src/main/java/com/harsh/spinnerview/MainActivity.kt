package com.harsh.spinnerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.harsh.spinnerview.databinding.ActivityMainBinding
import com.harsh.spinnerview.databinding.CustomAlertDialogueBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var itemsCount = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        spinner()
        binding.fab.setOnClickListener(){

            showDialogue()
        }

    }
    fun spinner(){
        val items = arrayOf("1","2","3","4","5")
        itemsCount.add("Test Item")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,itemsCount)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerView.adapter = adapter
        binding.spinnerView.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long)
            {
                var item = p0?.getItemAtPosition(p2)
                Toast.makeText(this@MainActivity,"$item",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }
    fun  showDialogue(){

        val dialogBinding = CustomAlertDialogueBinding.inflate(layoutInflater)
        var dialog = Dialog(this).apply {

            setContentView(dialogBinding.root)
            window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
          show()
        }
        dialogBinding.btnUpdate.setOnClickListener(){
            itemsCount.add(dialogBinding.etEnterupdate.text.toString())
            Log.e("itemList","showDialogue:$itemsCount")
            dialog.dismiss()
        }

    }


}