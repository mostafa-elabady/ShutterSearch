# ShutterSearch
Sample app for getting images from ShutterStock APIs

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

Please add your [ShutterStock API key](https://developers.shutterstock.com) in ```API_TOKEN``` in ```AppConstants.kt``
`
## Main entities ##

The project architecture is based on Model-View-ViewModel (MVVM) pattern.

`core` 
- ```base



