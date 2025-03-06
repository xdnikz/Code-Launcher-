package com.example.mylauncher

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.BaseAdapter

class AppAdapter(private val context: Context, private val appList: ArrayList<AppModel>) : BaseAdapter() {

    override fun getCount(): Int = appList.size
    override fun getItem(position: Int): Any = appList[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_app, parent, false)

        val appName = view.findViewById<TextView>(R.id.appName)
        val appIcon = view.findViewById<ImageView>(R.id.appIcon)

        val app = appList[position]

        appName.text = app.appName
        appIcon.setImageDrawable(app.appIcon)

        return view
    }
}
