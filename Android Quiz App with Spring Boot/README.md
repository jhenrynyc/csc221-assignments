# SpringQuizApp

## Introduction

SpringQuizApp is an Android and Spring Boot based quiz application. It allows users to take quizzes on various categories like sports, fruits, math, and general knowledge. The app uses Retrofit for network calls and interacts with a Spring Boot backend for quiz data.

## Features

- Multiple quiz categories.
- Interactive quiz interface on Android.
- Backend quiz management with Spring Boot.
- REST API for fetching quizzes and submitting answers.

## Getting Started

### Prerequisites

- Android Studio for Android app development.
- JDK and Spring Boot for backend development.
- MySQL or similar database for data persistence.
- Retrofit for network operations in the Android app.

### Building the App

1. Clone the repository to your local machine.
2. Open the Android part of the project in Android Studio.
3. Configure the backend URL in the Retrofit setup in `MainActivity.java`.
4. Run the backend Spring Boot application.
5. Start the Android application on an emulator or a physical device.

### Running the Backend

1. Navigate to the backend project directory.
2. Use `./mvnw spring-boot:run` or run the `SpringQuizAppApplication` class from your IDE to start the server.

## Backend API

The backend provides the following endpoints:

- `GET /api/quizzes`: Fetch all quizzes.
- `GET /api/quizzes/{id}`: Fetch a specific quiz.
- `POST /api/quizzes/{id}/submit`: Submit answers to a quiz.

## Project Structure

- Android App:
  - `MainActivity.java`: Main activity handling category selection.
  - `quizActivity.java`: Activity to display quiz questions and handle user interaction.
  - `Retrofit` setup for network calls.
- Spring Boot Backend:
  - `QuizController.java`: REST controller for quiz operations.
  - `Quiz`, `Question`, and `QuizRepository`: Model and repository for quiz data.
  - `SpringQuizAppApplication`: Main class to start the Spring Boot application.

## Dependencies

- AndroidX libraries for Android development.
- Retrofit and Gson for network operations.
- Spring Boot and JPA for backend development.
- MySQL driver for database operations.

---
