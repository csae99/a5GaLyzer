package com.example.OurApp.Screens

import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.content.Context as Context1


@RequiresApi(Build.VERSION_CODES.S)

@Composable
fun HomeScreen(){

    // Get device information
    val deviceInfo = getDeviceInfo()

    // Get WiFi  and cellular information
    val context = LocalContext.current
    val wifiManager = context.getSystemService(Context1.WIFI_SERVICE) as WifiManager
    val wifiInfo = getSupportedStandards(wifiManager)

   // Display information in two columns
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 10.dp)

    )
    {
        // First Column
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(BorderStroke(4.dp, Color.LightGray))

        ) {
            Text("\n \t Device Information \n", style = MaterialTheme.typography.headlineMedium)
            Text(deviceInfo, modifier = Modifier
                .padding(start = 10.dp),
                color = Color.DarkGray,
                style = MaterialTheme.typography.titleLarge)
        }

        // Second Column
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 10.dp)
                .weight(2f)
                .height(4.dp)
                .border(BorderStroke(4.dp, Color.LightGray))

        ) {
            Text(
                "\n\t  WiFi and Cellular Information \n",
                style = MaterialTheme.typography.headlineMedium
            )

            wifiInfo.forEach { (title, data) ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.Left
                ) {
                    Text("\t  Wi-Fi 6 band : \t", style = MaterialTheme.typography.headlineSmall)
                    Text(
                        title, modifier = Modifier.padding(start = 18.dp),
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = data, modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.Blue
                    )
                }
            }
        }
    }

}

@RequiresApi(Build.VERSION_CODES.S)
 @Composable
 fun Home(){
     HomeScreen() }

@Composable
fun getDeviceInfo(): String {
    val manufacturer = Build.MANUFACTURER
    val model = Build.MODEL
    val device = Build.DEVICE
    val brand = Build.BRAND
    val version = Build.VERSION.RELEASE
    val sdkVersion = Build.VERSION.SDK_INT.toString()

    return """
        Manufacturer: $manufacturer
        Model: $model
        Device: $device
        Brand: $brand
        OS Version: $version
        SDK Version: $sdkVersion
    """.trimIndent()

}

@RequiresApi(Build.VERSION_CODES.S)
@Deprecated(
    "Getting raw data is deprecated",
    replaceWith = ReplaceWith("navigationActionId")
)
fun getInfo(context: Context1): Map<String, Map<String, String>> {
    val wifiManager =
        context.applicationContext.getSystemService(Context1.WIFI_SERVICE) as WifiManager

    return mapOf(
        "Supported bands" to getSupportedBands(wifiManager),
        "Supported standards" to getSupportedStandards(wifiManager),
    )
}

@RequiresApi(Build.VERSION_CODES.S)
fun getSupportedBands(wifiManager: WifiManager): Map<String, String> {
    return mutableMapOf<String, String>().apply {
        this["2.4GHz"] = "${
            wifiManager.is24GHzBandSupported
        }"
        this["5GHz"] = "${wifiManager.is5GHzBandSupported}"
        this["6GHz"] = "${wifiManager.is6GHzBandSupported}"
        this["60GHz"] = "${wifiManager.is60GHzBandSupported}"
    }
}

@RequiresApi(Build.VERSION_CODES.S)
fun getSupportedStandards(wifiManager: WifiManager): Map<String, String>
{

        return mutableMapOf<String, String>().apply {
            this["802.11a/b/g"] = "${
                wifiManager.isWifiStandardSupported(
                    ScanResult.WIFI_STANDARD_LEGACY
                )
            }"
            this["802.11n"] = "${
                wifiManager.isWifiStandardSupported(
                    ScanResult.WIFI_STANDARD_11N
                )
            }"
            this["802.11ac"] = "${
                wifiManager.isWifiStandardSupported(
                    ScanResult.WIFI_STANDARD_11AC
                )
            }"
            this["802.11ax"] = "${
                wifiManager.isWifiStandardSupported(
                    ScanResult.WIFI_STANDARD_11AX
                )
            }"
            this["802.11ad"] = "${
                wifiManager.isWifiStandardSupported(
                    ScanResult.WIFI_STANDARD_11AD
                )
            }"
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                this["802.11be"] = "${
                    wifiManager.isWifiStandardSupported(
                        ScanResult.WIFI_STANDARD_11BE
                    )
                }"
            }
        }
}

//@Composable
//fun getCellularInfo():String {
//    val gsm =
//
//}






