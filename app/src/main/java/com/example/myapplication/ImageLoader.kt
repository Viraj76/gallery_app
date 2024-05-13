package com.example.myapplication

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.util.Log

class ImageLoader(private val context: Context) {

    fun loadImages(): List<String> {
        val imagesList = mutableListOf<String>()

        // Projection for the columns to retrieve from the MediaStore
        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DISPLAY_NAME
        )
//        Log.d("list" , projection.toString())

        // Sort images by date taken in descending o rder
        val sortOrder = "${MediaStore.Images.Media.DATE_TAKEN} DESC"

        // Querying MediaStore for images
        context.contentResolver.query(
            MediaStore.Images.Media.INTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            sortOrder
        )?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            val nameColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)

            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val name = cursor.getString(nameColumn)
                val contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon()
                    .appendPath(id.toString()).build()
                imagesList.add(contentUri.toString())
            }
        }
        return imagesList
    }



    fun fetchGalleryImages(context: Context): ArrayList<String> {
        val galleryImageUrls = ArrayList<String>()
        val columns = arrayOf(MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID)
        val orderBy = "${MediaStore.Images.Media.DATE_TAKEN} DESC"
        context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            columns,
            null,
            null,
            orderBy
        )?.use { cursor ->
            val dataColumnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA)
            while (cursor.moveToNext()) {
                galleryImageUrls.add(cursor.getString(dataColumnIndex))

            }
        }

        return galleryImageUrls
    }



}
