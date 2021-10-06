package com.example.notekeeper.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notekeeper.NOTE_POSITION
import com.example.notekeeper.NoteInfo
import com.example.notekeeper.R
import com.example.notekeeper.activities.NoteActivity

class NoteRecyclerAdapter(private val context: Context, private val notes: List<NoteInfo>):
    RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val viewCourse = itemView.findViewById<TextView?>(R.id.textCourse)
        val viewTitle  = itemView.findViewById<TextView?>(R.id.textTitle)
        var notePosition = 0

        init {
            itemView.setOnClickListener {
                val intent = Intent(context, NoteActivity::class.java)
                intent.putExtra(NOTE_POSITION, notePosition)
                context.startActivity(intent);
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.note_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]

        holder.viewCourse?.setText(note.course?.title)
        holder.viewTitle?.setText(note.title)
        holder.notePosition = position
    }

    override fun getItemCount() = notes.size
}