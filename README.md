# FuelWatch - Fuel Supply Disruption Monitor

An Android app that visualizes fuel supply disruptions at gas stations during disaster events in the Northern Virginia / Fairfax / DC area.

## Features (Phase 1)

- Interactive Google Map centered on NoVA/DC area
- 15 gas stations with mock disruption data
- Color-coded markers: Green (Normal), Yellow (Warning), Red (Disrupted)
- Tap any marker to see station details in a bottom sheet:
  - Station name and address
  - Disruption status badge
  - Signal sources: Traffic congestion, Social media mentions, Camera queue length
  - Last updated timestamp
- Status summary card showing active alerts
- Map legend overlay

## Tech Stack

- **Language:** Kotlin
- **UI Framework:** Jetpack Compose + Material 3
- **Maps:** Google Maps Compose SDK
- **Min SDK:** 26 (Android 8.0)
- **Target SDK:** 34 (Android 14)

## Setup

1. **Clone the repo** and open in Android Studio (Hedgehog or newer)

2. **Get a Google Maps API Key:**
   - Go to [Google Cloud Console](https://console.cloud.google.com/apis/credentials)
   - Create a project (or use an existing one)
   - Enable **Maps SDK for Android**
   - Create an API key

3. **Configure the API key:**
   - Copy `local.properties.example` to `local.properties`
   - Replace `YOUR_GOOGLE_MAPS_API_KEY_HERE` with your actual key:
     ```
     MAPS_API_KEY=AIzaSy...your_key_here
     ```

4. **Build and run** on an emulator or physical device

## Project Structure

```
app/src/main/java/com/devinetest/fuelwatch/
├── MainActivity.kt              # Entry point
├── data/
│   └── MockData.kt              # 15 mock gas stations with disruption data
├── model/
│   └── GasStation.kt            # Data models (GasStation, DisruptionStatus, etc.)
└── ui/
    ├── components/
    │   └── StationBottomSheet.kt # Station detail bottom sheet
    ├── map/
    │   └── MapScreen.kt         # Main map screen with markers and overlays
    └── theme/
        ├── Color.kt             # App color palette
        ├── Theme.kt             # Material 3 theme configuration
        └── Type.kt              # Typography definitions
```

## Future Phases

- **Phase 2:** Dashboard & alert summary screen
- **Phase 3:** Data source indicators (traffic API, NLP, computer vision)
- **Phase 4:** Real-time data integration (Google Maps Traffic API, social media, cameras)
- **Phase 5:** Disruption detection with rule-based/ML logic & push notifications
