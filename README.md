# Android Architecture Components

## What is it?
A collection of libraries that help to design robust, testable, and maintainable apps.
This includes:
 - Handling lifecycle
 - Live Data
 - View Model
 - Room
 - Dependency Injection
 
### Handling lifecycle
Lifecycle is a class that holds the information about the lifecycle state of a component (like an activity or a fragment) and allows other objects to observe this state.
 - LifecycleObserver: Observe the different states of the component's lifetime on behalf of the component(like ac activity or a fragment)
 - LifecycleOwner: Handles and implements the LifecycleObserver
  
### LiveData
They are data objects which are lifecycle aware and can observe the changes in the database.
This means when the component's lifecycle changes like the device rotation the LiveData respects that lifecycle and perform necessary changes.
And also with the change in the data in underlying database the LiveData can observe it and can notify the component. Normally it is used with **ViewModel**
 
### ViewModel
The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.  
This means ViewModel is aware of lifecycle and can observe the changes in lifecycle so that it can store and restore the UI data. ViewModel uses LiveData and is also very useful to share data between fragments with knowing the activity.
 
### Room
The Room persistence library provides an abstraction layer over SQLite to allow fluent database access. 
 
The library helps to create a cache of the app's data on a device that's running the app. This cache, which serves as app's single source of truth, allows users to view a consistent copy of key information within the app, regardless of whether users have an internet connection.
 
### Dependency Injection
Dependency injection is a concept valid for any programming language. The general concept behind dependency injection is called Inversion of Control. According to this concept a class should not configure its dependencies statically but should be configured from the outside.

There are many dependency injection library available. One of them is Dagger2. Dagger 2 is dependency injection framework. It is based on the Java Specification Request (JSR) 330. It uses code generation and is based on annotations. The generated code is very relatively easy to read and debug.

Dagger 2 uses the following annotations:
 - @Module and @Provides: define classes and methods which provide dependencies
 
 - @Inject: request dependencies. Can be used on a constructor, a field, or a method
 
 - @Component: enable selected modules and used for performing dependency injection
 
 
## Description:
In this project android architecture components are used to create an demo app for sqlite CRUD operations.
**Room** is used to enhance the sqlite's simplicity. 
**LiveData** and **ViewModel** are used to perform observable database operations.
**Dagger2** is used for performing dependency injection.

## Installation
Clone or download the repository and import into android studio. It may be needed to download missing platforms or to change the architecture components version in gradle. **Enjoy!**

## Copywrite
 - Name: Arhan Ashik
 - Signature: blackSpider
 - Email: ashik.pstu.cse@gmail.com