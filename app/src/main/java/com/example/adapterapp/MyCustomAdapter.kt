package com.example.adapterapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyCustomAdapter(private val context:Context, private val items:List<String>): BaseAdapter() {


    override fun getCount(): Int {
    // returns the number of item
        return items.size
    }

    override fun getItem(position: Int): Any {

        // Returns the data item associated with the specified
        // position at the dataset

        return items[position]
    }

    override fun getItemId(position: Int): Long {

        // Return a unique identifier for the item at the specified position
        return position.toLong()


    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        /*
        * Returns a view that displays the data at the specified position in the data set
        * convertView :recycled view that can be reused to optimize performance*/

        var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
        val view:View
        if (convertView == null){
            view = inflater.inflate(R.layout.list_item_layout,parent,false)
        } else{
            view = convertView
        }
        val item = getItem(position) as String
        val textView = view.findViewById<TextView>(R.id.lil_text)
        textView.text = item
        return view
    }

}