# jsreport-java-example-camel

Example of simple rendering at [Camel](https://camel.apache.org/) route. It use bean processing for calling jsreport render service.

## Build

Using maven from project director 
```
mvn clean package
```

## Run

1. start local jsreport service on port 5488

2. start application from project root using command: 
```
java -jar target/jsreport-java-example-camel-1.0.1-SNAPSHOT-jar-with-dependencies.jar
``` 

3. render requests

On start it creates directory *./in* where could be placed input JSON files (see *test/data/test.json*). When request
is succesfully created it will creates directory *./out* where will generated PDF file.

Example could be stop using Ctrl+C key combination.

