# jsreport-java-example-simple

Simple report rendering from Java main class.

## Build

Using maven run `mvn clean package` from project root. It will create output JAR files in `target` directory.

## Run

Before execution run local jsreport instance (e.g. using docker) on port 5488. Create some simple template titled 
'invoice-main'. It this template will not be ready in jsreport server then program output only one file!  

When project get built using Maven then run from project root this command:

```
java -jar target/jsreport-java-example-simple-1.0.1-SNAPSHOT-jar-with-dependencies.jar
```  

Program after run create 2 PDF files in project root directory named `report1.pdf` and `report2.pdf`. Which are result
of calling reporting service from Java client. 
