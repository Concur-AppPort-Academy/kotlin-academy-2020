# Lesson 4

## Content
- Collections
  - List
  - Set
  - Map
- Collection/MutableCollection
- Basic write operations
- Common operations
  - Transformations
  - Filtering
  - Grouping 
  ...

## Useful links
- [Slack channel](https://appport-academy.slack.com/) (invite can be requested via [event link](https://appport.cz/event/appport-academy/) or [Meetup group](https://www.meetup.com/Prague-Mobile-Development-Meetup/events/269765161/))
- [Github](https://github.com/Concur-Kotlin-Academy/academy2020)
- Kotlin manual: [link](https://kotlinlang.org/docs/reference/collections-overview.html)

## Tasks
### Project creation
1. open IntelliJ idea
1. select create new project
1. choose Kotlin/JVM
1. name the project "lesson-04"
1. create new Kotlin file in the `src` folder with name `Main`
1. add your first Kotlin code
```kotlin
fun main(){
    println("Hello World")
}
```
1. right click -> run `MainKt`

#### Task 1
1. Create list which contains Strings of days in week
1. Create set which contains numbers as order of days in week
1. Create map which contains days in week (Pair having day and number in week)

#### Task 2
1. Create method which will be able print all the values from both list and set
1. Create method which will print values from map

#### Task 3
1. Create mutable versions of previous objects
1. Try list specific write operations like:
  - add
  - remove
  - set
  - shuffle
  
#### Task 4
1. Transform map of days in week to simple list of days

#### Task 5
1. Filter list of days so it contains just days which are 8 chars long

#### Task 6
1. Verify if all items in list are 8 chars long
1. Verify if any of the items are 7 chars long
1. Find item which is 7 chars long

#### Task 7
1. Apply + and - operations on our list

#### Task 8
1. Group items in our list by first character of element
1. Print for each group just number of elements instead of inner list

#### Task Recap
1. use map created in the beginning of lesson and create set of Int from it
1. remove these items which are odd and print the number which is divisible by 4

## Additional sources
- Interactive playground for collections [link](https://play.kotlinlang.org/koans/Collections/Introduction/Task.kt)
