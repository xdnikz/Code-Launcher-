package com.example.mylauncher

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pm: PackageManager = packageManager
        val apps = pm.getInstalledApplications(PackageManager.GET_META_DATA)

        val appList = ArrayList<AppModel>()

        for (app in apps) {
            val label = app.loadLabel(pm).toString()
            val icon = app.loadIcon(pm)
            val packageName = app.packageName

            appList.add(AppModel(label, icon, packageName))
        }

        val gridView: GridView = findViewById(R.id.gridView)
        val adapter = AppAdapter(this, appList)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val intent = pm.getLaunchIntentForPackage(appList[position].packageName)
            if (intent != null) {
                startActivity(intent)
            }
        }
    }
}
