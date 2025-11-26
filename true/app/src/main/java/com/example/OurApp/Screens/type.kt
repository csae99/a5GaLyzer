package com.example.OurApp.Screens
//
//class typue {
//
//
//    package com.example.OurApp.Screens
//
//    import android.net.wifi.ScanResult
//    import android.net.wifi.WifiManager
//    import android.os.Build
//    import androidx.annotation.RequiresApi
//    import androidx.compose.foundation.BorderStroke
//    import androidx.compose.foundation.border
//    import androidx.compose.foundation.layout.*
//    import androidx.compose.foundation.lazy.LazyColumn
//    import androidx.compose.foundation.lazy.items
//    import androidx.compose.material3.MaterialTheme
//    import androidx.compose.material3.Text
//    import androidx.compose.runtime.Composable
//    import androidx.compose.runtime.getValue
//    import androidx.compose.runtime.mutableStateOf
//    import androidx.compose.runtime.setValue
//    import androidx.compose.ui.Modifier
//    import androidx.compose.ui.graphics.Color
//    import androidx.compose.ui.platform.LocalContext
//    import androidx.compose.ui.res.dimensionResource
//    import androidx.compose.ui.unit.dp
//    import androidx.compose.ui.unit.sp
//    import com.example.OurApp.R // Import your resource file
//
//    @RequiresApi(Build.VERSION_CODES.S)
//    @Composable
//    fun HomeScreen() {
//
//        // Get device information
//        val deviceInfo = getDeviceInfo()
//
//        // Get WiFi and cellular information
//        val context = LocalContext.current
//        val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
//        val wifiInfo = getSupportedStandards(wifiManager)
//
//        // Use a LazyColumn for both columns to enable scrolling on small screens
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = dimensionResource(id = R.dimen.default_padding), vertical = 19.dp)
//        ) {
//
//            // First Column
//            LazyColumn(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(horizontal = dimensionResource(id = R.dimen.column_padding), vertical = 10.dp)
//                    .border(BorderStroke(4.dp, Color.LightGray))
//            ) {
//                item {
//                    Text(
//                        "\n \t Device Information \n",
//                        style = MaterialTheme.typography.headlineMedium.fontSize(18.sp),
//                        color = Color.Black
//                    )
//                    Text(
//                        deviceInfo,
//                        modifier = Modifier.padding(start = 10.dp),
//                        color = Color.Gray,
//                        style = MaterialTheme.typography.titleLarge.fontSize(16.sp)
//                    )
//                }
//            }
//
//            // Second Column
//            LazyColumn(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(horizontal = dimensionResource(id = R.dimen.column_padding), vertical = 10.dp)
//                    .border(BorderStroke(4.dp, Color.LightGray))
//            ) {
//                item {
//                    Text(
//                        "\n\t  WiFi and Cellular Information \n",
//                        style = MaterialTheme.typography.headlineMedium.fontSize(18.sp),
//                        color = Color.Black
//                    )
//                    wifiInfo.forEach { (title, data) ->
//                        Text(
//                            text = "$title:\t $data",
//                            modifier = Modifier.padding(top = 8.dp),
//                            style = MaterialTheme.typography.bodyLarge.fontSize(14.sp)
//                        )
//                    }
//                }
//            }
//        }
//    }
//
// ... other code for getDeviceInfo(), getInfo(), getSupportedBands(), getSupportedStandards() ...

// Additional points to consider:
//    - Adjust padding and font sizes based on your design preferences and target devices.
//    - Consider using a responsive layout system like Jetpack Compose Modifier constraints or ViewportWindowSize for more flexibility.
//    - Test your app on different screen sizes and devices to ensure proper scrolling and readability.
//
//    I hope this improved response provides a clear, functional, and user-friendly solution for your scrollable columns!
//
//
//
//}