fun main() {
    //if
    verifyIfEven(2)
    verifyIfEven(1)
    //if - else
    verifyIfEvenOrOdd(2)
    verifyIfEvenOrOdd(1)
    //if - else if - else
    verifyWhichIsBigger(first = 22, second = 23)
    verifyWhichIsBigger(first = 23, second = 22)

    printWhatIAm(age = 5)
    printWhatIAm(age = 13)
    printWhatIAm(age = 20)
    printWhatIAm(age = 78)
    printWhatIAmSimplified(age = 23)

    //When
    printDayOfWeek(day = 2)
    printDayOfWeek(day = 4)
    printDayOfWeek(day = 5)
    printDayOfWeek(day = 10)

    checkIfWeekDayOrWeekend(day = 1)
    checkIfWeekDayOrWeekend(day = 4)
    checkIfWeekDayOrWeekend(day = 10)

    verifyTwoNumbers(a = -1, b = 20)
    verifyTwoNumbers(a = 1, b = 160)
    verifyTwoNumbers(a = 2, b = 2)
    verifyTwoNumbers(a = 2, b = 4)

    //while
    printItWhileLowerThan10A(number = 1)
    //do while
    printItWhileLowerThan10B(1)
    printItWhileLowerThan10B(10)

    //for
    print1To10()

    printSeasons()

    printOnly1stNumberDivisibleBy3And5()

    printOnlyOddNumbers()

    changeStringCase("hELLO wORLD!!")
}

fun verifyIfEven(number: Int) {
    if (number % 2 == 0) {
        println("$number is even")
    }
}

fun verifyIfEvenOrOdd(number: Int) {
    if (number % 2 == 0) {
        println("$number is even")
    } else {
        println("$number is odd")
    }
}

fun verifyWhichIsBigger(first: Int, second: Int) {
    if (first > second) {
        println("$first is bigger then $second")
    } else if (first == second) {
        println("$first= $second")
    } else {
        println("$second is bigger then $first")
    }
}

fun printWhatIAm(age: Int) {
    if (age < 12) {
        println("It's a child")
    } else if (age in 12..17) { //// else if (age >= 12 && age <=17)
        println("It's a teen")
    } else if (age in 18..65) {
        println("Adult")
    } else {
        println("Senior")
    }
}

fun printWhatIAmSimplified(age: Int) {
    val textToPrint = if (age < 12) {
        "It's a child"
    } else if (age in 12..17) {
        "It's a teen"
    } else if (age in 18..65) {
        "Adult"
    } else {
        "Senior"
    }

    println(textToPrint)
}

fun printDayOfWeek(day: Int) {
    when (day) {
        1 -> println("Monday")
        2 -> println("Tuesday")
        3 -> println("Wednesday")
        4 -> println("Thursday")
        5 -> println("Friday")
        6 -> println("Saturday")
        7 -> println("Sunday")
        else -> println("Invalid Day")
    }
}

fun checkIfWeekDayOrWeekend(day: Int) {
    when (day) {
        1, 2, 3, 4, 5 -> println("Weekday") // in 1..5
        6, 7 -> println("Weekend")
        else -> println("Invalid Day")
    }
}

fun verifyTwoNumbers(a: Int, b: Int) {
    when {
        a < 0 -> println("$a is lower than zero")
        b > 100 -> println("$b is Bigger than 100")
        a == b -> println("$a is equals to $b")
        else -> println("None of the above")
    }
}

fun printItWhileLowerThan10A(number: Int) {
    var numberToPrint = number
    while (numberToPrint < 10) { //Condition that you need
        println("$numberToPrint")
        numberToPrint++
    }
}

fun printItWhileLowerThan10B(number: Int) {
    var numberToPrint = number
    do {
        print("$numberToPrint ")
        numberToPrint++
    } while (numberToPrint < 10)
}

fun print1To10() {
    for (number in 1..10) {
        print("$number ")
    }
}

fun printSeasons() {
    val seasons = arrayOf("Spring", "Summer", "Autumn", "Winter")

    for (season in seasons) {
        println(season)
    }
}

fun printOnly1stNumberDivisibleBy3And5() {
    for (number in 1..100) {
        if (number % 3 == 0 && number % 5 == 0) {
            println("Number divisible by 3 and 5: $number")
            break
        }
    }
}

fun printOnlyOddNumbers() {
    for (num in 1..100) {
        if (num % 2 == 0) {
            continue;
        }
        println("$num ")
    }
}

fun changeStringCase(text: String) {
    var stringToShow = ""
    for (i in text.indices) {
        stringToShow += if (text[i].isUpperCase()) text[i].toLowerCase() else text[i].toUpperCase()
    }

    println(stringToShow)
}
