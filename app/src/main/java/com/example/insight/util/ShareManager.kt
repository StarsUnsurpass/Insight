package com.example.insight.util

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.content.FileProvider
import com.example.insight.data.local.dao.CourseWithTimeSlot
import com.google.gson.Gson
import java.io.File
import java.io.FileOutputStream
import java.util.Base64

class ShareManager(private val context: Context) {

    /**
     * 将课表数据序列化并生成“口令”
     */
    fun generateScheduleToken(courseWithSlots: List<CourseWithTimeSlot>): String {
        val json = Gson().toJson(courseWithSlots)
        val encoded = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Base64.getEncoder().encodeToString(json.toByteArray())
        } else {
            android.util.Base64.encodeToString(json.toByteArray(), android.util.Base64.DEFAULT)
        }
        return "#Insight课表#$encoded"
    }

    /**
     * 解析口令
     */
    fun parseScheduleToken(token: String): List<CourseWithTimeSlot>? {
        if (!token.startsWith("#Insight课表#")) return null
        val encoded = token.removePrefix("#Insight课表#")
        val json = try {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                String(Base64.getDecoder().decode(encoded))
            } else {
                String(android.util.Base64.decode(encoded, android.util.Base64.DEFAULT))
            }
        } catch (e: Exception) {
            return null
        }
        return try {
            val type = object : com.google.gson.reflect.TypeToken<List<CourseWithTimeSlot>>() {}.type
            Gson().fromJson(json, type)
        } catch (e: Exception) {
            null
        }
    }

    /**
     * 分享课表图片
     */
    fun shareScheduleImage(bitmap: Bitmap) {
        val cachePath = File(context.cacheDir, "images")
        cachePath.mkdirs()
        val file = File(cachePath, "schedule_export.png")
        val stream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        stream.close()

        val contentUri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
        
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "image/png"
            putExtra(Intent.EXTRA_STREAM, contentUri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        context.startActivity(Intent.createChooser(intent, "分享课表"))
    }
}
