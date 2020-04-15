# Lesson 1

## Content 
- Introduction of the course and teachers
- Setup of IDE
- Introduction to Basic Syntax  
- Introduction to Basic Types
    
## Useful links
- Slack channel invite can be requested via [event link](https://appport.cz/event/appport-academy/) or [Meetup group](https://www.meetup.com/Prague-Mobile-Development-Meetup/events/269765161/)
- [Github](https://github.com/Concur-Kotlin-Academy/academy2020) 
- Kotlin manual: [link](https://kotlinlang.org/docs/reference/basic-syntax.html)

## Course overview
The course will cover following topics. 
- Intellij setup & Basic Syntax + Basic Types
- Control flow
- Interface, Abstract Class
- Conventions & Collections
- Properties & Builders
- Basic IO operations
- Coroutines
- Kotlin HTTP server creation with Ktor
- Client Kotlin Ktor
- Kotlin multiplatform setup Xcode + Android studio
- Kotlin multiplatform client creation

## IDE Setup
The course is using IntelliJ IDEA Community edition. 
- [download link](https://www.jetbrains.com/idea/download/)
- once downloaded please install with default setup

## Tasks
### Project creation
1. open IntelliJ idea 
1. select create new project
1. choose Kotlin/JVM
1. name the project "lesson-01"
1. create new Kotlin file in the `src` folder with name `Main`  
1. add your first Kotlin code
```kotlin
fun main(){
    println("Hello World")
}
``` 
1. right click -> run `MainKt`

### Numbers
1. test difference between on following example:
```kotlin
val speed1 = 180
var speed2 = 190

//Try to guess before uncommenting which line below would cause an error.
//speed1 = speed2 
//speed2 = speed1

println(speed1)
println(speed2)
```
1. create variables with following types: `Short`, `Int`, `Long`, `Float`, `Double`
1. print result of addition of `Double` and `Int` number
### Booleans
1. create variable with False value
1. print the result of: `val result = true && ( false || true )`
### Arrays
1. create array of `Double` with size of 10
1. create array of `Int` with size of 5 and initial value 42
### Chars
1. create variable that hold char
1. try to concat chars
### Functions
1. create functions that returns `Double` for 2 `Double` numbers  addition, reduction, multiplication, division 
1. create a function with `Int` & `String` input parameters. The function prints to console concatenation of the inputs. 


## Additional sources
Interactive playground [link](https://play.kotlinlang.org/koans/Introduction/Hello,%20world!/Task.kt)