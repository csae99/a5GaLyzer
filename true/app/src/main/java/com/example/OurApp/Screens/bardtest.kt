// Initializing code with package
package com.example.OurApp.Screens

//Importing Libraries
import android.annotation.SuppressLint
import android.content.Context.*
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException

// State variables to hold speed test results
var downloadSpeed by mutableDoubleStateOf(0.0)
var uploadSpeed by mutableDoubleStateOf(0.0)
var ping by mutableIntStateOf(0)

// State variable to control test state
var isTesting by mutableStateOf(false)

     @Composable
     @SuppressLint("CoroutineCreationDuringComposition")
            fun PerformSpeedTest()
            {
                // Initialize upload and download speeds to 0.00
                downloadSpeed = 0.00
                uploadSpeed = 0.00
                ping = 0

                CoroutineScope(Dispatchers.IO).launch{
                try // Call all three measurement functions here
                {
                    measureDownloadSpeed(fileSize = 1024 * 1024)
                    { speed -> downloadSpeed = speed
                    }
                    measureUploadSpeed(fileSize = 1024 * 1024)
                    { speed -> uploadSpeed = speed
                    }
                    measurePing{ pingValue -> ping = pingValue }
                }
                    catch (e: Exception)
                    {
                      // Handle exceptions
                     println("Error during speed test: $e")// Display error message to the user
                    }
                }
            }

   @Composable
    fun SpeedTestScreen()
    {
        LocalContext.current
        val connectivityManager =
        LocalContext.current.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return // No internet
        val networkCapabilities =
        connectivityManager.getNetworkCapabilities(activeNetwork) ?: return

        if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
            // Internet available, start speed test

            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center)
            {
                // Display speed test results
                if (isTesting)
                {

                    Card(
                modifier = Modifier
                    .fillMaxWidth()

                   // .(Alignment.Center)
                    .padding(horizontal = 10.dp)
                    // Add border
                    .border(width = 1.dp, color = MaterialTheme.colorScheme.onSurface),

                shape = MaterialTheme.shapes.large, // Rounded corners
                 elevation = CardDefaults.cardElevation(defaultElevation = 14.dp)
            )
                    {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            verticalArrangement = Arrangement.Center
                        )
                        {

                            Spacer(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp ))
                            Text(
                                text = " \t Calculating Speed ",
                                style = MaterialTheme.typography.headlineMedium,
                                color = MaterialTheme.colorScheme.secondary
                            )
                            Spacer(modifier = Modifier.padding(14.dp))
                            Text(
                                text = " \t Download Speed: ${"%.2f".format(downloadSpeed / 1024)} Mbps \n",
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.secondary
                            )
                            Text(
                                text = " \t Upload Speed: ${"%.2f".format(uploadSpeed / 1024)} Mbps \n",
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.secondary
                            )
                            Text(
                                text = " \t Ping: $ping ms \n",
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.secondary
                            )

                        }
                    }
                }

                if (!isTesting)
                {
                        Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 25.dp)
                            .border(width = 1.dp, color = MaterialTheme.colorScheme.onSurface), // Add border
                        shape = MaterialTheme.shapes.small, // Rounded corners
                        elevation = CardDefaults.cardElevation(defaultElevation = 14.dp)
                        )
                        {

                    Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center)
                    {

                        Spacer(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp))
                        Text(
                        text = "\t Speed Test Results",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.secondary
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        Text(
                        text = " \t Download Speed: ${"%.2f".format(downloadSpeed / 1024)} Mbps \n",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.secondary
                        )
                        Text(
                        text = " \t Upload Speed: ${"%.2f".format(uploadSpeed / 1024)} Mbps \n",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.secondary
                        )
                        Text(
                        text = " \t Ping: ${"%02d".format(ping) }ms \n",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.secondary
                        )
                    }
                    }
                }
            }
                            // Button to start/stop test

             Button(modifier = Modifier
                 .fillMaxWidth()
                 .padding(horizontal = 30.dp, vertical = 50.dp)
                 .height(250.dp), //Add space and width below
                    onClick = { isTesting = !isTesting },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.tertiary, // Cyan color
                        contentColor = MaterialTheme.colorScheme.onTertiary
                    )
                ) {
                    Text(if (isTesting) "Stop Test" else "Start Test", style = MaterialTheme.typography.headlineLarge)
                }

        }

          // If testing is ongoing, start or stop the test
        if(isTesting)
        {
            PerformSpeedTest()
        }
    }

    // Function to measure download speed
    fun measureDownloadSpeed(fileSize: Int, callback: (Double) -> Unit)
    {
        CoroutineScope(Dispatchers.IO).launch {
            try
            {
                val startTime = System.currentTimeMillis()
                // Code to upload file to server and measure time taken
                delay(2000) // Simulating upload delay
                val endTime = System.currentTimeMillis()
                val durationSeconds = (endTime - startTime) / 1000.0
                val speedKbps = (fileSize / durationSeconds) * 8 / 1024
                callback(speedKbps)
            }
            catch (e: IOException)
            {
                // Handle exceptions
                callback(-1.0) // Error occurred, speed is -1.0
            }
        }
    }

    // Function to measure upload speed
    fun measureUploadSpeed(fileSize: Int, callback: (Double) -> Unit)
    {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val startTime = System.currentTimeMillis()
                // Code to upload file to server and measure time taken
                delay(2000) // Simulating upload delay
                val endTime = System.currentTimeMillis()
                val durationSeconds = (endTime - startTime) / 1000.0
                val speedKbps = (fileSize / durationSeconds) * 8 / 1024
                callback(speedKbps)
                }
                catch (e: IOException)
                {
                    // Handle exceptions
                    callback(-1.0) // Error occurred, speed is -1.0
                }
        }
    }

    // Function to measure ping
    fun measurePing(callback: (Int) -> Unit)
    {
        CoroutineScope(Dispatchers.IO).launch {
            try
            {
                val startTime = System.currentTimeMillis()
                // Code to ping server and measure time taken
                delay(1000) // Simulating ping delay
                val endTime = System.currentTimeMillis()
                val durationMilliseconds = endTime - startTime
                callback(durationMilliseconds.toDouble().toInt())
            }
            catch (e: IOException)
            {
                // Handle exceptions
                callback(-1) // Error occurred, ping is -1.0
            }
        }
    }

