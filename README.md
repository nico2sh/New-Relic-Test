# Java Agent Test App

## Instructions

1. Clone this repo.
2. Edit the `newrelic.yml` file.
3. Change the app name under the `app_name` section if you wish.
4. Go to the `license_key` and put your STAGING ingest API key there.
5. You already have a jar compiled for you (if you want to compile it yourself, execute `./gradlew build` and get the jar from the `build/libs` directory), so you can start the service with:
6. Check the `application_logging` section, there is all the configuration for sending logs, don't change anything, just admire.

```bash
> java -jar -javaagent:newrelic.jar test_app.jar 
```

6. Your service should be running, you can open a browser at `localhost:8080'
7. There are four different endpoints, all of them generate log lines:
    * The root `/`
    * `/hello`, you can pass the argument `?name=yourname`
    * `err`, generates an error log line
    * `npe` throws a null pointer exception, this is the one you want to use if you want to check the errors inbox
8. You can now set up Errros inbox in New Relic Staging. Check the [docs](https://developer.newrelic.com/automate-workflows/error-inbox/set-up-errors-inbox/)
