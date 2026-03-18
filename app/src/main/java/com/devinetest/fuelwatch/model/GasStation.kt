package com.devinetest.fuelwatch.model

import com.google.android.gms.maps.model.LatLng

/**
 * Represents a gas station with its location and disruption status.
 */
data class GasStation(
    val id: String,
    val name: String,
    val address: String,
    val location: LatLng,
    val status: DisruptionStatus,
    val trafficCongestion: CongestionLevel,
    val socialMediaMentions: Int,
    val queueLength: QueueLength,
    val lastUpdated: String
)

/**
 * Overall disruption status for a gas station.
 */
enum class DisruptionStatus(val label: String) {
    NORMAL("Normal"),
    WARNING("Warning"),
    DISRUPTED("Disrupted")
}

/**
 * Traffic congestion level near the gas station.
 */
enum class CongestionLevel(val label: String) {
    LOW("Low"),
    MODERATE("Moderate"),
    HIGH("High"),
    SEVERE("Severe")
}

/**
 * Estimated queue length at the gas station based on camera analysis.
 */
enum class QueueLength(val label: String) {
    NONE("No Queue"),
    SHORT("Short (1-5 cars)"),
    MEDIUM("Medium (5-15 cars)"),
    LONG("Long (15+ cars)")
}
