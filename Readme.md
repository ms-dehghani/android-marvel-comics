
# Android Marvel Comics App
In this application we will be using the Marvel API to fetch the comics and display them in a list.
The user can click on a comic to see more details about it.
we will be using the following API:
* https://developer.marvel.com/docs

and the following endpoints:
* /v1/public/comics
* /v1/public/comics/{comicId}

### Technologies
* Using Kotlin.
* Using Clean Architecture principles.
* Using MVVM.
* Using Modular structure.
* Using Jetpack Compose for the UI.
* Using Hilt for dependency injection.
* Using Retrofit for networking.
* Using Room for caching.
* Using Paging 3 for pagination.
* Using Kotlin Coroutine for asynchronous programming.
* Using Unit tests.
* Using Ui tests.
* Using Single activity, zero fragments.


## Architecture
The app is built using the Clean Architecture principles. The app is divided into 3 modules:
* `app` - The main module that contains the UI and the DI setup.
* `data` - The module that contains the data layer. It contains the repository and the data sources with api and mock data sources.
* `domain` - The module that contains the business logic. It contains the use cases and the models.

Every module is independent and can be tested separately. also they work together to achieve the final result.
this architecture makes the app more maintainable and testable and also makes it easier to add new features.
each layer use their own models and mappers to make the app more flexible and easy to maintain.
this is schema of the architecture:

![Alt text](./resource/architecture.png?raw=true "Architecture")



## UI
The UI is built using Jetpack Compose. The UI is divided into 2 screens:
* `ComicsListScreen` - The main screen that contains the list of comics.
* `ComicDetailsScreen` - The screen that contains the details of a comic.

![Alt text](./resource/main_screen.png?raw=true "ComicsListScreen")
![Alt text](./resource/detail_screen.png?raw=true "ComicDetailsScreen")


## Testing
The app contains unit tests and UI tests.
* `app` - Contains the UI tests.
* `data` - Contains the unit tests for both api and mock .
* `domain` - Contains the unit tests for the use cases.


We used turbine for testing the Flow and Mockk for mocking the objects.


Fork and enjoy! 🚀
