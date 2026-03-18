package com.devinetest.fuelwatch.data

import com.devinetest.fuelwatch.model.CongestionLevel
import com.devinetest.fuelwatch.model.DisruptionStatus
import com.devinetest.fuelwatch.model.GasStation
import com.devinetest.fuelwatch.model.QueueLength
import com.google.android.gms.maps.model.LatLng

/**
 * Mock data representing gas stations in Northern Virginia, Fairfax, and DC area.
 * In production, this would be replaced with real-time API data.
 */
object MockData {

    val gasStations: List<GasStation> = listOf(
        // --- DISRUPTED stations ---
        GasStation(
            id = "1",
            name = "Shell - Fairfax City",
            address = "10360 Main St, Fairfax, VA 22030",
            location = LatLng(38.8462, -77.3064),
            status = DisruptionStatus.DISRUPTED,
            trafficCongestion = CongestionLevel.SEVERE,
            socialMediaMentions = 47,
            queueLength = QueueLength.LONG,
            lastUpdated = "2 min ago"
        ),
        GasStation(
            id = "2",
            name = "Exxon - Arlington Blvd",
            address = "5765 Lee Hwy, Arlington, VA 22207",
            location = LatLng(38.8837, -77.1195),
            status = DisruptionStatus.DISRUPTED,
            trafficCongestion = CongestionLevel.HIGH,
            socialMediaMentions = 32,
            queueLength = QueueLength.LONG,
            lastUpdated = "5 min ago"
        ),
        GasStation(
            id = "3",
            name = "BP - Georgia Ave NW",
            address = "4515 Georgia Ave NW, Washington, DC 20011",
            location = LatLng(38.9419, -77.0234),
            status = DisruptionStatus.DISRUPTED,
            trafficCongestion = CongestionLevel.SEVERE,
            socialMediaMentions = 58,
            queueLength = QueueLength.LONG,
            lastUpdated = "1 min ago"
        ),

        // --- WARNING stations ---
        GasStation(
            id = "4",
            name = "Sunoco - Falls Church",
            address = "6520 Arlington Blvd, Falls Church, VA 22042",
            location = LatLng(38.8628, -77.1553),
            status = DisruptionStatus.WARNING,
            trafficCongestion = CongestionLevel.MODERATE,
            socialMediaMentions = 12,
            queueLength = QueueLength.MEDIUM,
            lastUpdated = "8 min ago"
        ),
        GasStation(
            id = "5",
            name = "Citgo - Annandale",
            address = "4234 Annandale Rd, Annandale, VA 22003",
            location = LatLng(38.8304, -77.1960),
            status = DisruptionStatus.WARNING,
            trafficCongestion = CongestionLevel.HIGH,
            socialMediaMentions = 15,
            queueLength = QueueLength.SHORT,
            lastUpdated = "3 min ago"
        ),
        GasStation(
            id = "6",
            name = "Marathon - Connecticut Ave",
            address = "4625 Connecticut Ave NW, Washington, DC 20008",
            location = LatLng(38.9481, -77.0634),
            status = DisruptionStatus.WARNING,
            trafficCongestion = CongestionLevel.MODERATE,
            socialMediaMentions = 9,
            queueLength = QueueLength.MEDIUM,
            lastUpdated = "12 min ago"
        ),
        GasStation(
            id = "7",
            name = "Shell - Springfield",
            address = "6500 Springfield Mall, Springfield, VA 22150",
            location = LatLng(38.7771, -77.1728),
            status = DisruptionStatus.WARNING,
            trafficCongestion = CongestionLevel.HIGH,
            socialMediaMentions = 18,
            queueLength = QueueLength.MEDIUM,
            lastUpdated = "6 min ago"
        ),

        // --- NORMAL stations ---
        GasStation(
            id = "8",
            name = "7-Eleven - Tysons",
            address = "8397 Leesburg Pike, Tysons, VA 22182",
            location = LatLng(38.9175, -77.2286),
            status = DisruptionStatus.NORMAL,
            trafficCongestion = CongestionLevel.LOW,
            socialMediaMentions = 0,
            queueLength = QueueLength.NONE,
            lastUpdated = "15 min ago"
        ),
        GasStation(
            id = "9",
            name = "Wawa - Centreville",
            address = "5615 Stone Rd, Centreville, VA 20120",
            location = LatLng(38.8396, -77.4280),
            status = DisruptionStatus.NORMAL,
            trafficCongestion = CongestionLevel.LOW,
            socialMediaMentions = 1,
            queueLength = QueueLength.NONE,
            lastUpdated = "20 min ago"
        ),
        GasStation(
            id = "10",
            name = "Costco Gas - Pentagon City",
            address = "1200 S Fern St, Arlington, VA 22202",
            location = LatLng(38.8615, -77.0586),
            status = DisruptionStatus.NORMAL,
            trafficCongestion = CongestionLevel.LOW,
            socialMediaMentions = 0,
            queueLength = QueueLength.SHORT,
            lastUpdated = "10 min ago"
        ),
        GasStation(
            id = "11",
            name = "Exxon - Reston",
            address = "1850 Reston Pkwy, Reston, VA 20190",
            location = LatLng(38.9553, -77.3419),
            status = DisruptionStatus.NORMAL,
            trafficCongestion = CongestionLevel.LOW,
            socialMediaMentions = 0,
            queueLength = QueueLength.NONE,
            lastUpdated = "25 min ago"
        ),
        GasStation(
            id = "12",
            name = "Shell - Dupont Circle",
            address = "1401 P St NW, Washington, DC 20005",
            location = LatLng(38.9097, -77.0336),
            status = DisruptionStatus.NORMAL,
            trafficCongestion = CongestionLevel.MODERATE,
            socialMediaMentions = 2,
            queueLength = QueueLength.NONE,
            lastUpdated = "7 min ago"
        ),
        GasStation(
            id = "13",
            name = "Gulf - Herndon",
            address = "698 Elden St, Herndon, VA 20170",
            location = LatLng(38.9696, -77.3861),
            status = DisruptionStatus.NORMAL,
            trafficCongestion = CongestionLevel.LOW,
            socialMediaMentions = 0,
            queueLength = QueueLength.NONE,
            lastUpdated = "30 min ago"
        ),
        GasStation(
            id = "14",
            name = "Mobil - Alexandria",
            address = "3815 Mount Vernon Ave, Alexandria, VA 22305",
            location = LatLng(38.8285, -77.0589),
            status = DisruptionStatus.NORMAL,
            trafficCongestion = CongestionLevel.LOW,
            socialMediaMentions = 1,
            queueLength = QueueLength.NONE,
            lastUpdated = "18 min ago"
        ),
        GasStation(
            id = "15",
            name = "BP - Woodbridge",
            address = "14401 Jefferson Davis Hwy, Woodbridge, VA 22191",
            location = LatLng(38.6392, -77.2578),
            status = DisruptionStatus.NORMAL,
            trafficCongestion = CongestionLevel.LOW,
            socialMediaMentions = 0,
            queueLength = QueueLength.NONE,
            lastUpdated = "22 min ago"
        )
    )
}
