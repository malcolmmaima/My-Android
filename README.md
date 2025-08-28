# 🚀 Android MVVM + Jetpack Compose Boilerplate

A modern, production-ready Android starter project built with **MVVM architecture**, **Jetpack Compose**, and **Hilt dependency injection**. This boilerplate provides a solid foundation for building scalable Android applications with best practices.

## ✨ Features

- **🏗️ Clean Architecture** - MVVM pattern with clear separation of concerns
- **🎨 Modern UI** - Jetpack Compose with Material 3 design system
- **💉 Dependency Injection** - Hilt for clean dependency management
- **🌐 Networking Ready** - Retrofit + OkHttp + Moshi setup
- **🧭 Navigation** - Compose Navigation with type-safe routing
- **🎯 State Management** - ViewModels with StateFlow
- **🔧 Build Tools** - Gradle with Kotlin DSL and Spotless formatting
- **📱 Modern Android** - Target SDK 34, minimum SDK 21

## 🏗️ Architecture Overview

```
┌─────────────────────────────────────────────────────────────┐
│                    Presentation Layer                       │
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────┐ │
│  │   MainActivity  │  │  WelcomeScreen  │  │ EmptyScreen │ │
│  └─────────────────┘  └─────────────────┘  └─────────────┘ │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                     ViewModel Layer                         │
│  ┌─────────────────────────────────────────────────────────┐ │
│  │                  MainViewModel                          │ │
│  │              (State Management)                         │ │
│  └─────────────────────────────────────────────────────────┘ │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                      Domain Layer                           │
│  ┌─────────────────────────────────────────────────────────┐ │
│  │                Repository Interfaces                    │ │
│  │              (Business Logic)                          │ │
│  └─────────────────────────────────────────────────────────┘ │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                      Data Layer                             │
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────┐ │
│  │   ApiService    │  │   Repository    │  │ Data Models │ │
│  │   (Retrofit)    │  │ Implementation  │  │             │ │
│  └─────────────────┘  └─────────────────┘  └─────────────┘ │
└─────────────────────────────────────────────────────────────┘
```

## 🛠️ Tech Stack

| Component | Technology | Version |
|-----------|------------|---------|
| **Language** | Kotlin | 1.9.0 |
| **UI Framework** | Jetpack Compose | 1.6.8 |
| **Architecture** | MVVM + Clean Architecture | - |
| **Dependency Injection** | Hilt | 2.47 |
| **Networking** | Retrofit + OkHttp + Moshi | 2.9.0 / 4.12.0 / 1.15.0 |
| **Navigation** | Compose Navigation | 2.7.7 |
| **State Management** | ViewModel + StateFlow | - |
| **Build System** | Gradle + Kotlin DSL | 8.5.1 |
| **Code Quality** | Spotless + KTLint | 6.25.0 |

## 📁 Project Structure

```
app/
├── src/main/
│   ├── java/malcolm/android/dev/newemptycomposeapp/
│   │   ├── data/                    # Data layer
│   │   │   ├── api/                 # API interfaces
│   │   │   ├── repository/          # Repository implementations
│   │   │   └── util/                # Utility classes
│   │   ├── di/                      # Dependency injection
│   │   │   ├── AppModule.kt         # App-level dependencies
│   │   │   └── NetworkModule.kt     # Networking dependencies
│   │   ├── ui/                      # UI layer
│   │   │   ├── screens/             # Compose screens
│   │   │   │   ├── WelcomeScreen.kt # Welcome screen
│   │   │   │   └── EmptyScreen.kt   # Empty screen
│   │   │   ├── theme/               # UI theming
│   │   │   ├── MainActivity.kt      # Main activity
│   │   │   └── MainViewModel.kt     # Main view model
│   │   └── navigation/              # Navigation
│   │       ├── NavGraph.kt          # Route definitions
│   │       └── AppNavigation.kt     # Navigation setup
│   └── res/                         # Resources
├── build.gradle.kts                 # App-level build config
└── AndroidManifest.xml              # App manifest

gradle/
└── libs.versions.toml              # Version catalog

build.gradle.kts                     # Project-level build config
settings.gradle.kts                  # Project settings
gradle.properties                    # Gradle properties
```

## 🚀 Getting Started

### Prerequisites

- **Android Studio** Arctic Fox (2020.3.1) or later
- **JDK 17** or later
- **Android SDK** API level 21 (Android 5.0) or higher
- **Gradle** 8.5.1 or later

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/android-mvvm-compose-boilerplate.git
   cd android-mvvm-compose-boilerplate
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory and select it

3. **Sync and Build**
   - Wait for Gradle sync to complete
   - Build the project: `Build → Make Project`
   - Run on device/emulator: `Run → Run 'app'`

### First Run

The app will launch with:
- **Welcome Screen** - Displays a greeting and navigation button
- **Navigation** - Tap the button to navigate to an empty screen
- **Back Navigation** - Use the back button or "Go Back" button

## 🔧 Configuration

### Customizing the App

1. **Update Package Name**
   ```kotlin
   // In app/build.gradle.kts
   namespace = "your.package.name"
   
   // In AndroidManifest.xml
   package="your.package.name"
   ```

2. **Change App Name**
   ```xml
   <!-- In res/values/strings.xml -->
   <string name="app_name">Your App Name</string>
   ```

3. **Update API Base URL**
   ```kotlin
   // In di/NetworkModule.kt
   .baseUrl("https://your-api-domain.com/")
   ```

### Adding New Screens

1. **Create Screen Composable**
   ```kotlin
   @Composable
   fun NewScreen() {
       // Your screen content
   }
   ```

2. **Add Route to NavGraph**
   ```kotlin
   sealed class Screen(val route: String) {
       object NewScreen : Screen("new_screen")
   }
   ```

3. **Add to Navigation**
   ```kotlin
   composable(Screen.NewScreen.route) {
       NewScreen()
   }
   ```

## 🌐 API Integration

The project comes with a complete networking setup ready for your API:

### Current Setup
- **Retrofit** - HTTP client for API calls
- **OkHttp** - HTTP client with logging
- **Moshi** - JSON parsing library
- **Hilt Integration** - Dependency injection for networking

### Adding Your API
1. **Update ApiService.kt** with your endpoints
2. **Create data models** for your API responses
3. **Implement repository methods** for data operations
4. **Add ViewModel logic** for state management

## 🎨 UI Customization

### Theme System
- **Material 3** design system
- **Dynamic colors** support (Android 12+)
- **Dark/Light themes** with automatic switching
- **Custom color schemes** in `ui/theme/Color.kt`

### Adding New Components
- Create reusable composables in `ui/components/`
- Follow Material 3 design guidelines
- Use the existing theme system for consistency

## 📱 Building and Deployment

### Debug Build
```bash
./gradlew assembleDebug
```

### Release Build
```bash
./gradlew assembleRelease
```

### Code Quality
```bash
# Format code
./gradlew spotlessApply

# Check formatting
./gradlew spotlessCheck
```

## 🧪 Testing

### Unit Tests
- Place test files in `src/test/`
- Use JUnit 4 or 5
- Test ViewModels, Repositories, and Use Cases

### UI Tests
- Place test files in `src/androidTest/`
- Use Compose Testing library
- Test screen navigation and interactions

## 📚 Key Concepts

### MVVM Architecture
- **Model** - Data and business logic
- **View** - UI components (Compose screens)
- **ViewModel** - State management and business logic

### State Management
- **StateFlow** - Reactive state streams
- **ViewModel** - Lifecycle-aware state holder
- **Unidirectional Data Flow** - UI → ViewModel → Repository

### Dependency Injection
- **Hilt** - Android DI framework
- **Modules** - Dependency providers
- **Scopes** - Lifecycle management

## 🔍 Troubleshooting

### Common Issues

1. **Build Fails with KTLint Errors**
   - KTLint is disabled in this project for flexibility
   - Code formatting is handled by Spotless

2. **Gradle Sync Issues**
   - Check internet connection
   - Clear Gradle cache: `./gradlew clean`
   - Invalidate caches in Android Studio

3. **Navigation Issues**
   - Ensure routes are properly defined in `NavGraph.kt`
   - Check that screens are added to `AppNavigation.kt`

### Performance Tips

- Use `remember` and `derivedStateOf` for expensive computations
- Implement proper state hoisting
- Use `LaunchedEffect` for side effects
- Avoid unnecessary recompositions

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## 📄 License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- **Google** - For Jetpack Compose and Android architecture components
- **Android Community** - For best practices and guidance
- **Open Source Contributors** - For the libraries that make this possible

## 📞 Support

- **Issues** - Create an issue on GitHub
- **Discussions** - Use GitHub Discussions for questions
- **Documentation** - Check the [Android Developer Docs](https://developer.android.com/)

---

**Happy Coding! 🎉**

Built with ❤️ using modern Android development practices.