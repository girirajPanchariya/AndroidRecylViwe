package com.cscorner.kotline_first

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var nameInput: TextInputEditText
    private lateinit var descriptionInput: TextInputEditText
    private lateinit var recyclerView: RecyclerView

    private val itemList = mutableListOf<items_Data>()
    private lateinit var adapter: AdepterClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Find views
        nameInput = findViewById(R.id.nameInput)
        descriptionInput = findViewById(R.id.descriptionInput)
        button = findViewById(R.id.ClickMe)
        recyclerView = findViewById(R.id.recyclerView)

        // Initial data
        itemList.addAll(
            listOf(
                items_Data("Item 1", "Giriraj"),
                items_Data("Item 2", "Kotlin"),
                items_Data("Item 3", "Android"),
                items_Data("Item 4", "RecyclerView"),
                items_Data("Item 5", "Mobile Development")
            )
        )

        // RecyclerView
        adapter = AdepterClass(itemList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Button click
        button.setOnClickListener {

            val name = nameInput.text.toString().trim()
            val description = descriptionInput.text.toString().trim()

            // Name validation
            if (name.isEmpty()) {
                Toast.makeText(
                    this,
                    "Name cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            // Description validation
            if (description.isEmpty()) {
                Toast.makeText(
                    this,
                    "Description cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            // Create new item
            val newItem = items_Data(
                title = name,
                description = description
            )

            // Add item
            itemList.add(newItem)

            // Update RecyclerView
            adapter.notifyItemInserted(itemList.size-1 )

            // Scroll to new item
            recyclerView.scrollToPosition(itemList.size-1 )

            // Clear inputs
            nameInput.text?.clear()
            descriptionInput.text?.clear()

            // Success message
            Toast.makeText(
                this,
                "Data added successfully",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}