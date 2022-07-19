# WeatherApp

This Application uses compose for UI,
<br/>
This application includes MVI design pattern,
<br/>
Libraries used: Dagger Hilt (for dependecy injection), Retrofit (for service and main safety), Coroutines (for main safety), Moshi ( JSON serialization), etc.
<br/>
This application complies with solid principles.

## What Is Compose And What's Diffrent Between XML?

Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Compose allows us to create UI with less code than XML. Composables can hold a state and re-run on state changes. This is called Recomposition. Compose improves your build time and APK size.

## What Is MVI Pattern

The scalability of the application ensures that updates can be seamlessly added to the application. Some applications may have ever-changing states (loading, error, loaded, etc.). In applications with such content, separating UI and business logic may be right to get out of an application crisis.

Why I didn't use MVVM pattern?

Whereas in MVVM there is usually a separate publisher for each piece of data, in MVI a single object defining the entire state of the view is published.

![image](https://user-images.githubusercontent.com/47060539/179554354-20980269-4ba1-4b4c-a661-f60cc9de537a.png)

## What Is Dagger Hilt And Why Should Use It?

Dagger hilt is simply dependency injection library. So, firstly we should ask what is dependency injection to ourself. Dependency injection is basically providing the objects that an object needs (its dependencies) instead of having it construct them itself. It's a very useful technique for testing, since it allows dependencies to be mocked or stubbed out.  We can get back to our dagger topic. Dagger can give us access to classes from anywhere throughout the life of the application or the lifetime of a particular activity and similar structures. I used this structure I mentioned in the service, in the location and in the repository.

## What Is Retrofit?

The library provides a powerful framework for authenticating and interacting with APIs and sending network requests with OkHttp. This library makes downloading JSON or XML data from a web API fairly straightforward. Once the data is downloaded then it is parsed into a Plain Old Java Object (POJO) which must be defined for each "resource" in the response. 


## What Is Coroutines?

In my opinion, the most important structure in an application is coroutines. On Android, coroutines help to manage long-running tasks that might otherwise block the main thread and cause your app to become unresponsive. In this application, in order not to block the main thread and not to freeze the ui, the use of coroutines was used for operations such as pulling data with the network and finding the user's location. So how do we achieve this? It's actually very simple. Answer: With Suspend functions. Suspending functions are at the center of everything coroutines. A suspending function is simply a function that can be paused and resumed at a later time. They can execute a long running operation and wait for it to complete without blocking.

The syntax of a suspending function is similar to that of a regular function except for the addition of the suspend keyword. It can take a parameter and have a return type. However, suspending functions can only be invoked by another suspending function or within a coroutine.


##

![image](https://user-images.githubusercontent.com/47060539/179724816-63bfabf4-7879-4048-b2ac-8355b0115178.png) ![image](https://user-images.githubusercontent.com/47060539/179724744-044903c0-db40-4b6d-84b6-371b52c0c101.png)




