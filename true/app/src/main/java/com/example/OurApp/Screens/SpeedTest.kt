package com.example.OurApp.Screens
// SpeedTest.kt

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

// Function to measure ping using OkHttp
fun measurePing(serverUrl: String): Double {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url(serverUrl)
        .build()

    return try {
        val startTime = System.currentTimeMillis()
        val response = client.newCall(request).execute()
        val endTime = System.currentTimeMillis()
        response.close()
        (endTime - startTime).toDouble()
    } catch (e: IOException) {
        -1.0 // Error occurred, ping is -1.0
    }
}

// Function to measure download speed using OkHttp
fun measureDownloadSpeed(fileSize: Int, serverUrl: String): Double {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url(serverUrl)
        .build()

    return try {
        val startTime = System.currentTimeMillis()
        val response = client.newCall(request).execute()
        val endTime = System.currentTimeMillis()
        val durationSeconds = (endTime - startTime) / 1000.0
        val contentLength = response.body?.contentLength() ?: 0
        response.close()
        (contentLength / durationSeconds) * 8 / 1024 / 1024 // Calculate speed in Mbps
    } catch (e: IOException) {
        -1.0 // Error occurred, speed is -1.0
    }
}

// Function to measure upload speed using OkHttp
fun measureUploadSpeed(fileSize: Int, serverUrl: String): Double {
 //  Implementation for measuring upload speed
    return -1.0 // Placeholder implementation
}

// Composable function to display speed test results and speedometer
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SpeedTest() {
    val serverUrl = "https://azspeedtest.blob.core.windows.net/100mb.bin"

    var downloadSpeed = 0.0
    var uploadSpeed = 0.0
    var ping = 0.0

    CoroutineScope(Dispatchers.Main).launch {
        downloadSpeed = measureDownloadSpeed(1024 * 1024, serverUrl)
        uploadSpeed = measureUploadSpeed(1024 * 1024, serverUrl)
        ping = measurePing(serverUrl)
    }

    Column {
        Text("Download Speed: ${if (downloadSpeed >= 0) "$downloadSpeed Mbps" else "Unavailable"}")
        Text("Upload Speed: ${if (uploadSpeed >= 0) "$uploadSpeed Mbps" else "Unavailable"}")
        Text("Ping: ${if (ping >= 0) "$ping ms" else "Unavailable"}")

    }
}
