# Android Internship Project  
An Android app that have 4 activities:
1. Home(MainScreen) 
2. List View(ListScreen) 
3. Detail of List Elements(DetailScreen) 
4. Open Links(BrowserScreen)

### Function of each activity 
Home page is just for navigation between List and Browser Activity.
The list fetches posts from the JSONPlaceholder REST API, caches them locally with Room, and keeps working offline.
The DetailScreen shows description of selected list element with name of element on top.
The BrowserScreen has text field where you can enter the url and it will open it on browser.

## Screenshots
| Home | List | Offline Error | Detail | Browser |
|------|------|---------------|--------|---------|
| <img width="270" height="549" alt="Screenshot Home" src="https://github.com/user-attachments/assets/109b2b20-ec59-438a-829e-ff3b18370c50" /> | <img width="270" height="549" alt="Screenshot List Screen" src="https://github.com/user-attachments/assets/d0b739ad-1a9d-41ac-9a24-a1d64410597f" /> | <img width="270" height="549" alt="Screenshot Offline List" src="https://github.com/user-attachments/assets/7369f8cc-2f31-47c0-b8e1-d41a13ba1a06" /> | <img width="270" height="549" alt="Screenshot Detail Screen" src="https://github.com/user-attachments/assets/2e03268c-1868-453b-b28b-124c9d3865a8" /> | <img width="270" height="549" alt="Screenshot Browser" src="https://github.com/user-attachments/assets/78fcb4a3-b08c-47b2-9c02-27d1628e8d51" /> |
 
## Features
- All screens are build with Compose Navigation
- Live data from https://jsonplaceholder.typicode.com/posts in ListScreen
- Offline support: last-synced data is shown without a connection of list
- Pull-to-refresh in ListScreen to sync from the API
- Visible loading spinner and error message with Retry when internet is not available while opening first time
- BrowserScreen has implicit intent to open a URL

## Tech Stack
- Kotlin, Jetpack Compose, Navigation Compose
- Retrofit + Gson (networking)
- Room (local database)
- Coroutines and Flow
- ViewModel (MVVM)

## Architecture of recyclerViewActivity
```
Compose UI  →  ViewModel  →  Repository  →  Retrofit (network)
                                         ↘  Room (local cache)
```
Room is the single source of truth. The Repository fetches from the API, writes the result into Room, and the UI observes Room through a Flow. If the network call fails, the UI keeps showing the cached data.

## Setup
1. Clone the repo: [`git clone <repo-url>`](https://github.com/varunsinghparihar/Android-Internship-Project.git)
2. Open it in Android Studio.
3. Let Gradle sync, then run on an emulator or device.
4. No API key is needed.

## Project Structure
```
<package>/
├── data/      (PostEntity, PostDao, AppDatabase, PostRepository, PostApi)
├── ui/        (MainScreen, ListScreen, DetailScreen, BrowserScreen, theme)
└── viewmodel/ (PostViewModel)
```
