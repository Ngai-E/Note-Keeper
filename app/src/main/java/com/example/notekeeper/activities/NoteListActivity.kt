package com.example.notekeeper.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notekeeper.DataManager
import com.example.notekeeper.adapters.NoteRecyclerAdapter
import com.example.notekeeper.databinding.ActivityNoteListBinding

class NoteListActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            val mainActivityIntent = Intent(this, NoteActivity::class.java)
            startActivity(mainActivityIntent)
        }

        binding.conNote.listItems.layoutManager = LinearLayoutManager(this)
        binding.conNote.listItems.adapter       = NoteRecyclerAdapter(this, DataManager.notes)
    }

    override fun onResume() {
        super.onResume()
        binding.conNote.listItems.adapter?.notifyDataSetChanged()
    }

}