# News App

## Overview
The News App is a Kotlin-based application that provides users with the latest headlines and articles from various sources. Utilizing the NewsAPI for fetching news data, this app is designed using the MVVM architecture, ensuring a clear separation of concerns and improved maintainability.

## Features

- **News Fetching**: 
  - Fetches the latest news articles and headlines from multiple news sources using the NewsAPI.

- **Search Functionality**: 
  - Users can search for specific articles based on keywords, allowing for a personalized news experience.

- **Favorites Management**: 
  - Users can save their favorite articles to a local Room database for easy access later.

- **Modern UI**: 
  - A clean and user-friendly interface that enhances user experience while browsing through articles.

- **Responsive Design**: 
  - Adapts to various screen sizes, providing a consistent experience across devices.

## Architecture
The app is built on the **MVVM (Model-View-ViewModel)** architecture pattern. This approach helps in separating the UI from business logic, making the code more modular and testable.

- **Model**: Represents the data structure and handles data operations (e.g., API calls, database operations).
- **View**: The UI components that display the data and handle user interactions.
- **ViewModel**: Acts as a bridge between the Model and the View, providing data to the UI and handling user actions.

## Technologies Used
- **Kotlin**: Primary programming language for Android development.
- **Retrofit**: A type-safe HTTP client for Android and Java, used for API interaction.
- **Room Database**: An abstraction layer over SQLite, used for local data storage and management.
- **LiveData**: A lifecycle-aware data holder class that allows UI components to observe changes in the data.

