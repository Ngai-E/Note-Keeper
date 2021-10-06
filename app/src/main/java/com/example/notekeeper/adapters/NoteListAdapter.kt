package com.example.notekeeper.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.notekeeper.NoteInfo
import com.example.notekeeper.R

class NoteListAdapter(private val context: Activity,
                      private val resource: Int,
                      private val notes: ArrayList<NoteInfo>):ArrayAdapter<NoteInfo>(context, resource, notes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView  = inflater.inflate(R.layout.note_item, null, true)

        return rowView
    }
}