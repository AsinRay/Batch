# JobMain
spring boot with batch

## Bug
With spring boot 2.5.0, you should create a folder under the config/ before running the app
otherwise the exception is thrown:
java.lang.IllegalStateException: No subdirectories found for mandatory directory location 'file:./config/*/'.



cd /config && mkdir aa