package com.workbook.liuwb.workbook.actions.function.file

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.databinding.ActivityFilesListBinding
import com.workbook.liuwb.workbook.databinding.ItemListBinding
import java.io.File

class FliesListActivity : AppCompatActivity() {

    private val binding: ActivityFilesListBinding by lazy {
        ActivityFilesListBinding.inflate(layoutInflater)
    }

    private lateinit var privateRootDir: File
    private lateinit var imagesDir: File
    private lateinit var imageFiles: Array<File>
    private lateinit var resultIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        resultIntent = Intent("com.example.myapp.ACTION_RETURN_FILE")

        privateRootDir = filesDir
        imagesDir = File(privateRootDir, "images")

        imageFiles = imagesDir.listFiles()
        setResult(Activity.RESULT_CANCELED, null)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.filesRecycler.layoutManager = layoutManager
        binding.filesRecycler.adapter = FilesAdapter(imageFiles) { position, path ->
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

private class FilesAdapter(
    private val list: Array<File>,
    private val itemClick: (position: Int, path: String) -> Unit
) : RecyclerView.Adapter<FilesAdapter.FilesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        val binding: ItemListBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return FilesViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FilesViewHolder, position: Int) {
        holder.itemText.text = list[position].absolutePath
        holder.itemView.setOnClickListener {
            itemClick(position, list[position].absolutePath)
        }
    }

    class FilesViewHolder(binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        val itemText = binding.itemText
    }
}