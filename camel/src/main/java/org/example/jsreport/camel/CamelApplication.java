package org.example.jsreport.camel;

import org.apache.camel.main.Main;

public class CamelApplication {

    public static void main(String[] args) throws Exception {
        // use Camels Main class
        Main main = new Main();

        // lets use a configuration class (you can specify multiple classes)

        // (properties are automatic loaded from application.properties)
        main.configure().addConfigurationClass(ApplicationConfiguration.class);

        // and add the routes (you can specify multiple classes)
        main.configure().addRoutesBuilder(RenderRoute.class);

        // now keep the application running until the JVM is terminated (ctrl + c or sigterm)
        main.run(args);

    }
}
