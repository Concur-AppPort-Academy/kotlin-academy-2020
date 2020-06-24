# Lesson 11

## Content
Kotlin Multiplatform
- project setup
    - Android part
    - shared part  
    - iOS part
- actual/expect
- Ktor Client

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
### New multiplatform app
Option1: 
1. Dowload example app from the Github with name "kotlin-mp1-start"
2. run Android project in emulator  

Option2:
1. Open Intellij and choose new Kotlin project
2. Choose mobile Android/iOS
3. Once the IDE load the project exchange/add following with conterparts in repo:
    1. add `version.gradle`
    2. replace `build.gradle`
    3. replace `app/build.gradle`
    4. get `gradlew` and run `chmod u+x gradlew` to make it executable
    5. get content of `gradle/wrapper`
4. clean and rebuild the project
5. run Android project in emulator 

### Run the app in XCode
1. Open XCode
2. Navigate to folder `base_dir/iosApp/`
3. Run iosApp.xcodeproj
4. Clean & build the project
5. Check in simulator that the app is running

### Add new Kotlin only code
- create new Helper class which has method that returns length of the input string
- define common interface Device that has method for getting name and brand. 
    - Prepare implementation in iOS and Android
- define data class Teacher in the kotlinCommon  and use it in Android and iOS

### Setup for common networking
1. Setup requires to add dependencies to your `app/build.gradle`. Feel free to take the source set definition from example [here](https://github.com/Concur-Kotlin-Academy/academy2020/blob/11/11/kotlin-mp1-end/app/build.gradle)  
2. While being in the `app/build.gradle` add following to Android config you will need to take over the packagingOptions and compileOptions 
3. Higher amount of dependencies is unfortunatelly requesting you to increase the build heap size. This is done in the `gradle.properties`
```kotlin
org.gradle.jvmargs=-Xmx4000m
```

### Networking class
1. Create class NetworkClient and setup client and call Heroku's endpoint `https://kotlin-test-app-10.herokuapp.com/hello_world` 
2. Add to networking possiblity to get all expenses from endpoint: `https://kotlin-test-app-10.herokuapp.com/expenses`




