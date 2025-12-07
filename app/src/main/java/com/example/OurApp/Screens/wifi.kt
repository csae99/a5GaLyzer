package com.example.analyzer.Screens


//import android.content.Context
//import android.net.wifi.ScanResult
//import android.net.wifi.WifiManager
//import android.os.Build
////import androidx.compose.material3.darkColorScheme
////import android.os.Bundle
//
//fun getDeviceInfo(): String {
//    val manufacturer = Build.MANUFACTURER
//    val model = Build.MODEL
//    val device = Build.DEVICE
//    val brand = Build.BRAND
//    val version = Build.VERSION.RELEASE
//    val sdkVersion = Build.VERSION.SDK_INT.toString()
//
//    return """
//        Manufacturer: $manufacturer
//        Model: $model
//        Device: $device
//        Brand: $brand
//        OS Version: $version
//        SDK Version: $sdkVersion
//    """.trimIndent()
//}
//
//fun main() {
//    val deviceInfo = getDeviceInfo()
//    println(deviceInfo)
//}
//
//@Deprecated("Getting raw data is deprecated", replaceWith = ReplaceWith("navigationActionId"))
//fun getInfo(context: Context): Map<String, Map<String, String>> {
//    val wifiManager =
//        context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
//
//    return mapOf(
//        "Supported bands" to getSupportedBands(wifiManager),
//        "Supported standards" to getSupportedStandards(wifiManager),
//    )
//}
//
//fun getSupportedBands(wifiManager: WifiManager): Map<String, String> {
//    return mutableMapOf<String, String>().apply {
//        this["2.4GHz"] = "${
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//                wifiManager.is24GHzBandSupported
//            } else {
//                true
//            }
//        }"
//        this["5GHz"] = "${wifiManager.is5GHzBandSupported}"
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            this["6GHz"] = "${wifiManager.is6GHzBandSupported}"
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            this["60GHz"] = "${wifiManager.is60GHzBandSupported}"
//        }
//    }
//}
//
//fun getSupportedStandards(wifiManager: WifiManager): Map<String, String> {
//    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
//        return mapOf()
//    }
//
//    return mutableMapOf<String, String>().apply {
//        this["802.11a/b/g"] = "${
//            wifiManager.isWifiStandardSupported(
//                ScanResult.WIFI_STANDARD_LEGACY
//            )
//        }"
//        this["802.11n"] = "${
//            wifiManager.isWifiStandardSupported(
//                ScanResult.WIFI_STANDARD_11N
//            )
//        }"
//        this["802.11ac"] = "${
//            wifiManager.isWifiStandardSupported(
//                ScanResult.WIFI_STANDARD_11AC
//            )
//        }"
//        this["802.11ax"] = "${
//            wifiManager.isWifiStandardSupported(
//                ScanResult.WIFI_STANDARD_11AX
//            )
//        }"
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            this["802.11ad"] = "${
//                wifiManager.isWifiStandardSupported(
//                    ScanResult.WIFI_STANDARD_11AD
//                )
//            }"
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            this["802.11be"] = "${
//                wifiManager.isWifiStandardSupported(
//                    ScanResult.WIFI_STANDARD_11BE
//                )
//            }"
//        }
//    }
//}
//
//
