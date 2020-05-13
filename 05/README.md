# Lesson 5

## Content
- Properties
  - general overview
  - backing Properties
  - nullability
  - delegates 
  - `lateinit var` & `by lazy` 
- Destructuring Declarations
- Builders

## Useful links
- [Slack channel](https://appport-academy.slack.com/) (invite can be requested via [event link](https://appport.cz/event/appport-academy/) or [Meetup group](https://www.meetup.com/Prague-Mobile-Development-Meetup/events/269765161/))
- [Github](https://github.com/Concur-Kotlin-Academy/academy2020)
- Kotlin manual: [link](https://kotlinlang.org/docs/reference/properties.html)

## Tasks
### Project creation
1. open IntelliJ idea
1. select create new project
1. choose Kotlin/JVM
1. name the project "lesson-05"
1. create new Kotlin file in the `src` folder with name `Main`
1. add your first Kotlin code

    ```kotlin
    fun main(){
        println("Hello World")
    }
    ```
1. right click -> run `MainKt`

#### Task 1
1. Create class named `NewCar` that has **final** constructor parameters `name: String`, `buildYear: Int` and `price: Int`
1. try to override `toString()` so that it prints out info about instance of the class
1. Add default values for the parameters
1. Add non-constructor final param `brand:String` 

#### Task 2
1. Create class named `BazarCar` that has constructor parameters **final** `name: String` and **non final** `buildYear: Int` & `price: Int`
1. try to override `toString()` so that it prints out info

#### Task 3
1. Create class `CustomizableCar` that has **non final** parameters `name: String`, `buildYear: Int` & `price: Int`
1. Define setter that prevents you from setting buildYear lower than 2000
1. Define own getter for `price` that increases value each time someone asks for the value
1. Define setter for `price` that prints previous and new value before setting it
  
#### Task 4
1. Create class `ExperimentalCar` with nullable parameters `protonEngine: String`, `sonicBreaks: String` 
1. Replace nullable protonEngine with delegate and check that value is initialized on engine start (create method `engineStart`)
1. Replace nullable sonicBreakes with `lateinit var`
1. Change the `NewCar` from Task1 to allow setting price via Delegate    

#### Task 5
1. Create class named `FixedCar` that has **final** parameters `name: String`, `buildYear: Int`
1. create a new instance of FixedCar and deconstruct it back to variables

#### Task 6
1. Convert following code to working implementation
```kotlin
val carBuilder = car {
        engine {
            type = "Product"
        }
    }
```

#### Task Recap
1. Create class `SimpleCar` with lateinit parameters ,`wheelBrand: WheelBrand`, `breaks: Breaks`
1. SimpleCar initializes the `distanceCounter` only after first `engineStart`
1. Create class `CarProvider` that will use has method assemble that takes as input wheel brand and breaks and produces new car

## Additional sources
- Interactive playground for properties [link](https://play.kotlinlang.org/koans/Properties/Properties/Task.kt)
