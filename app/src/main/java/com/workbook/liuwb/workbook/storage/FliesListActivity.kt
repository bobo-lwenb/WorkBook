package com.workbook.liuwb.workbook.storage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_files_list.*
import kotlinx.android.synthetic.main.item_list.view.*
import java.io.File

class FliesListActivity : AppCompatActivity() {

    private lateinit var privateRootDir: File
    private lateinit var imagesDir: File
    private lateinit var imageFiles: Array<File>
    private lateinit var resultIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_files_list)

        resultIntent = Intent("com.example.myapp.ACTION_RETURN_FILE")

        privateRootDir = filesDir
        imagesDir = File(privateRootDir, "images")

        imageFiles = imagesDir.listFiles()
        setResult(Activity.RESULT_CANCELED, null)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        files_recycler.layoutManager = layoutManager
        files_recycler.adapter = FilesAdapter(imageFiles) { position, path ->
            val requestFile = File(path)
            val fileUri = try {
                FileProvider.getUriForFile(this, "${this.applicationContext.packageName}.provider", requestFile)
            } catch (e: IllegalArgumentException) {
                Log.e("File Selector", "The selected file can't be shared: $requestFile")
                null
            }
            if (fileUri != null) {
                resultIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                resultIntent.setDataAndType(fileUri, contentResolver.getType(fileUri))
                setResult(Activity.RESULT_OK, resultIntent)
            } else {
                resultIntent.setDataAndType(null, "")
                setResult(Activity.RESULT_CANCELED, resultIntent)
            }
            finish()
        }
    }
}

private class FilesAdapter(private val list: Array<File>, private val itemClick: (position: Int, path: String) -> Unit)
    : RecyclerView.Adapter<FilesAdapter.FilesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return FilesViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FilesViewHolder, position: Int) {
        holder.itemView.item_text.text = list[position].absolutePath
        holder.itemView.setOnClickListener {
            itemClick(position, list[position].absolutePath)
        }
    }

    inner class FilesViewHolder(view: View) : RecyclerView.ViewHolder(view)
}