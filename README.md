# ShutterSearch
Android sample app for getting images from ShutterStock APIs, it's using [/v2/images/search] (https://api-reference.shutterstock.com/?javascript--nodejs#images-search-for-images) endpoint for searching for images.
this solution is focused on building Android app.

The app is built with MVVM and clean arcitecture.


Room is the source of data 

![How paging is working] (https://codelabs.developers.google.com/codelabs/android-paging/img/511a702ae4af43cd.png)

### Why MVVM? ###

- MVVM separates your view from your business logic.
- Android Architecture Components already provides a built-in ViewModel class.
- Separate the responsibilities of your code base


### Why clean architecture? ###

- App code is more easily testable than with plain MVVM.
- decoupling layers.
- The package structure is even easier to navigate.
- The project is even easier to maintain.

## Libraries ##
- [RXJava2](https://github.com/ReactiveX/RxJava) Reactive programming library 
- [Retrofit](https://square.github.io/retrofit) For REST API communication
- [OkHttp](https://square.github.io/okhttp) HTTP client
- [Moshi Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/moshi) A `Converter` which uses [Moshi](https://github.com/square/moshi) for serialization to and from JSON.
- [Koin](https://github.com/InsertKoinIO/koin) A pragmatic lightweight dependency injection framework for Kotlin developers.
- [Room](https://developer.android.com/jetpack/androidx/releases/room)  provides an abstraction layer over SQLite
- [Paging](https://developer.android.com/topic/libraries/architecture/paging.html) to load data gradually within your  RecyclerView
- [Espresso](https://developer.android.com/training/testing/espresso) For UI testing
- [Mockito](https://site.mockito.org/) Mocking framework for unit testing
- [Glide](https://github.com/bumptech/glide) for image loading


## Clone ##
```git clone https://github.com/mostafa-elabady/ShutterSearch.git```

## Installation ##

Please add your [ShutterStock API key](https://developers.shutterstock.com) in ```API_TOKEN``` in ```AppConstants.kt```

## Main entities ##

The project architecture is based on Model-View-ViewModel (MVVM) pattern.

`core` for core classes to be used across the app
- `base` contains ```BaseViewModel``` for loading handling
- `constant` for App constants
- `db` for Data base handling
- `di` for dependency injection handling using `koin`
- `network` for API network handling.

`search` main package for search feature
- `data` for data handling using a repository, remote calling, and also caching local.
- `model` API model and app UI models
- `view` contains main views, adapters,etc.
- `viewmodel` contains the view model.


## Public profile ##
[LinkedIn] (https://www.linkedin.com/in/mostafaelabady)



Description of the problem and solution.


The reasoning behind your technical choices, including architectural.

Trade-offs you might have made, anything you left out, or what you might do differently if you were to spend additional time on the project.

Link to the hosted application where applicable.



