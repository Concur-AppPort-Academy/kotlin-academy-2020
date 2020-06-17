# Lesson 10 - Ktor Server Deployment

## Useful links
* [Slack channel](https://appport-academy.slack.com/) (invite can be requested via [event link](https://appport.cz/event/appport-academy/) or [Meetup group](https://www.meetup.com/Prague-Mobile-Development-Meetup/events/269765161/))
* [Github](https://github.com/Concur-Kotlin-Academy/academy2020)
* [Kotlin reference](https://kotlinlang.org/docs/reference/)
* [Ktor server reference](https://ktor.io/servers/index.html)
* [Generate a Ktor project](https://ktor.io/quickstart/generator.html#)
* [Heroku.com](https://heroku.com)

## Tasks
1. Launch Ktor project from the last lesson
2. Package the project
   * Use Gradle Shadow library
   * Update build.gradle
   * Create `*.jar` file that contains all dependencies of the project
   * Modify `build.gradle`
     ```
     classpath 'com.github.jengelman.gradle.plugins:shadow:5.2.0'
     
     apply plugin: 'com.github.johnrengelman.shadow'
     
     shadowJar {
         archiveFileName = "appport-academy.jar"
         manifest {
             attributes 'Main-Class': mainClassName
         }
     }
     ```
3. Create account on Heroku.com
   * Install Git CLI and Heroku CLI
   * Validate installation and login
     ```
     git version
     heroku version
     heroku login
     ```
4. Deploy to Heroku
   * Create `Procfile`
     ```
     web:    java -jar build/libs/appport-academy.jar
     ```
   * Create `system.properties`
     ```
     java.runtime.version=1.8
     ```
   * Deploy to Heroku
     ```
     git init
     heroku git:remote -a appport-academy
     git add *
     git commit -m 'first deployment'
     heroku config:set GRADLE_TASK="shadowJar"
     git push heroku master
     ```
   * Verify

## Optional tasks
1. Create database on Heroku
   * 10 000 rows for free
     ```
     heroku addons:create heroku-postgresql
     ```
2. Connect to the database
   * Obtain credentials
     ```
     heroku config
     ```
   * Modify `build.gradle`
     ```
     implementation "org.jetbrains.exposed:exposed-core:0.24.1"
     implementation "org.jetbrains.exposed:exposed-dao:0.24.1"
     implementation "org.jetbrains.exposed:exposed-jdbc:0.24.1"
     implementation "org.postgresql:postgresql:42.2.10"
     ```
3. First database transaction
   * Create table Expenses in `/setup_db` endpoint
4. Update POST and GET `/expenses` endpoints
   * Use `insert()` and `selectAll()` methods on `Expenses` object
5. Update PUT, GET and DELETE `/expenses/{expenseId}` endpoints
   * Use `select()`, `update()` and `deleteWhere()` methods on `Expenses` object
