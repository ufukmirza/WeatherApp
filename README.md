# WeatherApp


This application includes MVI design pattern,
Libraries used: Dagger Hilt (for dependecy injection), Retrofit (for service and main safety), Coroutines (for main safety), Moshi ( JSON serialization), etc.
This application complies with solid principles.

## What Is MVI Pattern

The scalability of the application ensures that updates can be seamlessly added to the application. Some applications may have ever-changing states (loading, error, loaded, etc.). In applications with such content, separating UI and business logic may be right to get out of an application crisis.

Why I didn't use MVVM pattern?

Whereas in MVVM there is usually a separate publisher for each piece of data, in MVI a single object defining the entire state of the view is published.

![image](https://user-images.githubusercontent.com/47060539/179554354-20980269-4ba1-4b4c-a661-f60cc9de537a.png)

## What Is Dagger Hilt And Why Should Use It?

Dagger hilt is simply dependency injection library. So, firstly we should ask what is dependency injection to ourself. Dependency injection is basically providing the objects that an object needs (its dependencies) instead of having it construct them itself. It's a very useful technique for testing, since it allows dependencies to be mocked or stubbed out.  We can get back to our dagger topic. Dagger can give us access to classes from anywhere throughout the life of the application or the lifetime of a particular activity and similar structures. I used this structure I mentioned in the service, in the location and in the repository.

## What Is Retrofit?

The library provides a powerful framework for authenticating and interacting with APIs and sending network requests with OkHttp. This library makes downloading JSON or XML data from a web API fairly straightforward. Once the data is downloaded then it is parsed into a Plain Old Java Object (POJO) which must be defined for each "resource" in the response. 




