# WeatherApp


This application includes MVI design pattern,
Libraries used: Dagger Hilt (for dependecy injection), Retrofit (for service and main safety), Coroutines (for main safety), Moshi ( JSON serialization), etc.
This application complies with solid principles.

## What Is MVI Pattern

The scalability of the application ensures that updates can be seamlessly added to the application. Some applications may have ever-changing states (loading, error, loaded, etc.). In applications with such content, separating UI and business logic may be right to get out of an application crisis.

Why I didn't use MVVM pattern?

Whereas in MVVM there is usually a separate publisher for each piece of data, in MVI a single object defining the entire state of the view is published.

![image](https://user-images.githubusercontent.com/47060539/179554298-22a6ea9d-deb0-42b4-88bd-08ef045c6587.png)

## What Is Dagger Hilt And Why Should Use It?




