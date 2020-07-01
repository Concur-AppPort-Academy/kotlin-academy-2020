# Lesson 12

## Content
Kotlin Multiplatform
- Ktor Client -> GET & POST
- CocoaPods support
- Concurrency

## Useful links
- [Slack channel](https://appport-academy.slack.com/) (invite can be requested via [event link](https://appport.cz/event/appport-academy/) or [Meetup group](https://www.meetup.com/Prague-Mobile-Development-Meetup/events/269765161/))
- [Github](https://github.com/Concur-Kotlin-Academy/academy2020)
- Android studio: [link](https://developer.android.com/studio/install)
- Android emulator setup: [link]( https://developer.android.com/studio/run/emulator#install)
- XCode installation: [link](https://apps.apple.com/us/app/xcode/id497799835?ls=1&mt=12)
- Kotlin Multiplatform documentation: [link1](https://kotlinlang.org/docs/reference/multiplatform.html) [link2](https://kotlinlang.org/docs/reference/platform-specific-declarations.html) 

## A little bit of theory
### Why?
To enable code sharing and especially business logic sharing.

### How?
Whenever possible write pure Kotlin code that is compiled and reusable on any platform. If there are already great libraries existing that solve the issue for given platform then use `expect/actul` to allow platform specific implementation.

### Which platforms are supported?
JVM (Android), Native (iOS), Javascript, iOS, Linux, Windows, Mac

## Tasks
### Setup
1. Dowload example app from the Github with name "lesson-start"
2. start Android project in emulator
3. start project in XCode simulator 

### Networking
- create Expense class, make is serializable and use it to obtain list of expense from server
- post new Expense to server

### CocoaPods
1. Open `app/build.gradle` and add plugin `apply plugin: "org.jetbrains.kotlin.native.cocoapods"` 
2. Add version variable, cocoapods setup and disable framework creation previous way
```kotlin
// CocoaPods requires the podspec to have a version.
version = "1.0.0"

kotlin {
    cocoapods {
        // Configure fields required by CocoaPods.
        summary = "My Test app"
        homepage = "some URL"
    }
...
}
``` 
3. Sync project and check that you have available new `podspec` task and run it
4. Setup your project to use cocoapods

### Concurrency
1. Create a `expect` class MyExecutor with method `runInNewThread` and implement it for Android and iOS and run following code with it
```kotlin
var sum = 0
for (i in 0..200000) {
    sum += i
}
```
2. Enhance the `runInNewThread` so that you can pass lambda to it
3. 



