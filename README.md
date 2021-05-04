# Albums wiki

### Libraries used

* RetroFit - Retrofit as a REST Client library and for caching the API response
* Gson - Gson converter as a Retrofit response mapping library

### Android components

* RecyclerView - Used to list the Albums.
* Constraintlayout - Simple, flat hierarchies in a layout.
* Data binding - bind the data with the UI. Also improves performance and help prevent memory leaks and null pointer exceptions.

### Android Architecture Components(Android Jetpack)

* ViewModel - allows data to survive configuration changes such as screen rotations.
* LiveData - lifecycle-aware data holder class to respects the lifecycle Fragments. 
* AndroidX - Complete project implemented using AndroidX libraries.

### Design

The application is based on MVVM design pattern. 

### Further enhancements

* Use of Dependency injection libraries like Dagger
* Room database for data persistence.
* Progressbar to show loading while fetching the data from the API
* Improving the data source fetch using Paging With Database And Network
* furthurmore, cosmetics and refractoring is an endless thought.
