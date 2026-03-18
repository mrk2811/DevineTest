package com.devinetest.fuelwatch.ui.map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devinetest.fuelwatch.data.MockData
import com.devinetest.fuelwatch.model.DisruptionStatus
import com.devinetest.fuelwatch.model.GasStation
import com.devinetest.fuelwatch.ui.components.StationBottomSheet
import com.devinetest.fuelwatch.ui.components.statusColor
import com.devinetest.fuelwatch.ui.theme.StatusRed
import com.devinetest.fuelwatch.ui.theme.StatusYellow
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(modifier: Modifier = Modifier) {
    val stations = MockData.gasStations

    // Center on Northern Virginia / DC area
    val dcArea = LatLng(38.8800, -77.1700)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(dcArea, 10.5f)
    }

    var selectedStation by remember { mutableStateOf<GasStation?>(null) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)

    val disruptedCount = stations.count { it.status == DisruptionStatus.DISRUPTED }
    val warningCount = stations.count { it.status == DisruptionStatus.WARNING }

    Box(modifier = modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = MapProperties(mapType = MapType.NORMAL),
            uiSettings = MapUiSettings(
                zoomControlsEnabled = true,
                myLocationButtonEnabled = false
            )
        ) {
            stations.forEach { station ->
                val markerColor = when (station.status) {
                    DisruptionStatus.NORMAL -> BitmapDescriptorFactory.HUE_GREEN
                    DisruptionStatus.WARNING -> BitmapDescriptorFactory.HUE_YELLOW
                    DisruptionStatus.DISRUPTED -> BitmapDescriptorFactory.HUE_RED
                }

                Marker(
                    state = MarkerState(position = station.location),
                    title = station.name,
                    snippet = "${station.status.label} - Tap for details",
                    icon = BitmapDescriptorFactory.defaultMarker(markerColor),
                    onInfoWindowClick = {
                        selectedStation = station
                    },
                    onClick = {
                        selectedStation = station
                        false
                    }
                )
            }
        }

        // Status summary card overlay
        if (disruptedCount > 0 || warningCount > 0) {
            Card(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 48.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f)
                ),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Warning,
                        contentDescription = null,
                        tint = if (disruptedCount > 0) StatusRed else StatusYellow,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Fuel Supply Alert",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "$disruptedCount disrupted, $warningCount warning of ${stations.size} stations",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // Legend
        Card(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 12.dp, bottom = 24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f)
            ),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = "Status",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                LegendItem(color = statusColor(DisruptionStatus.NORMAL), label = "Normal")
                LegendItem(color = statusColor(DisruptionStatus.WARNING), label = "Warning")
                LegendItem(color = statusColor(DisruptionStatus.DISRUPTED), label = "Disrupted")
            }
        }
    }

    // Bottom sheet
    if (selectedStation != null) {
        ModalBottomSheet(
            onDismissRequest = { selectedStation = null },
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            StationBottomSheet(station = selectedStation!!)
        }
    }
}

@Composable
private fun LegendItem(color: androidx.compose.ui.graphics.Color, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 2.dp)
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .padding(1.dp)
        ) {
            androidx.compose.foundation.Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(color = color)
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
