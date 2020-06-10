# Lesson 9 - Ktor Server

## Useful links
* [Slack channel](https://appport-academy.slack.com/) (invite can be requested via [event link](https://appport.cz/event/appport-academy/) or [Meetup group](https://www.meetup.com/Prague-Mobile-Development-Meetup/events/269765161/))
* [Github](https://github.com/Concur-Kotlin-Academy/academy2020)
* [Kotlin reference](https://kotlinlang.org/docs/reference/)
* [Ktor server reference](https://ktor.io/servers/index.html)
* [Generate a Ktor project](https://ktor.io/quickstart/generator.html#)

## Theory

* Communication between client and server using TCP/IP (Transmission Control Protocol/Internet Protocol)
* Communication standard defined by HTTP (HyperText Transfer Protocol)
* Example request:
  ```
  GET / HTTP/1.1
  Host: google.com
  ```
* Example response:
  ```
  HTTP/1.1 200 OK
  ```
* Commonly used methods: 
  * GET (safe)
  * POST
  * PUT (idempotent)
  * DELETE (idempotent)
* Commonly used response status codes:
  * 1XX (informational) - 100 Continue (with sending the request body)
  * 2XX (success) - 200 OK, 201 Created, 204 No Content
  * 3XX (redirection) - 301 Moved permanently (all requests should be redirected elsewhere)
  * 4XX (client error) - 400 Bad Request, 401 Unauthorized, 404 Not Found, 418 I'm a teapot (April Fools' joke of 1998)
  * 5XX (server error) - 500 Internal Server Error, 501 Not Implemented
 
## Tasks
1. Launch Ktor project
   * Generate project structure using IntelliJ IDEA Ktor plugin
   * Generate project structurie online on https://ktor.io/quickstart/generator.html#
2. Create Hello world endpoint
   * Simple GET endpoint that returns short strict to the caller
   * Often implemented to quickly verify the application is still responding
3. Send data to the server in URL
   * Retrieve variable from URL path
   * Read query parameters
4. Send data to the server in request body
   * Simple POST endpoint that reads request payload and returns it to the user
5. Create resource on the server
   * Upload `expense` to the server and store it to a file
   * Code snippets needed to handle JSON serialization
   ```
   classpath "org.jetbrains.kotlin:kotlin-serialization:$kotlin_version"
   
   implementation "io.ktor:ktor-serialization:$ktor_version"
   ```
6. Read resources on the server
   * Read list of `expenses` stored in a file

## Optional tasks
1. Update resources on the server
   * Update `expense` by its ID 
2. Delete resource from the server
   * Delete `expense` by its ID
3. Read a single resource from the server
   * Read `expense` by its ID
4. Return HTML
   * Return HTML response that is correctly interpreted by a web browser

## Next lesson
Choose one of the following:

1. Packaging and deployment of the server to the Internet
   * Learn how to create a Java archive with our code and deploy it on the Internet
   * We will use [Heroku](https://www.heroku.com/) which requires registration (10 minute e-mail can be used)
   * Free for our purposes and experimentation afterwards
   * We will be able to call our server in the next lessons
2. Playing with AWS
   * Learn how to call commonly used AWS services - S3 and SQS
   * You will be provided with a key and a secret to our AWS account - the key will have limited permissions and will be deactivated after our lesson
   * You will not be able to experiment with it after our lesson unless you use your own AWS account (paid, but free trial is available)
3. More Ktor features
   * Learn about other features Ktor offers, such as Authorization, Status pages (exception handling) and logging 
