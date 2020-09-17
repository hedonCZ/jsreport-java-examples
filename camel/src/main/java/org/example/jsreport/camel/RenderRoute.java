package org.example.jsreport.camel;

import net.jsreport.java.dto.RenderRequest;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenderRoute extends RouteBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(RenderRoute.class);

    @Override
    public void configure() throws Exception {
        from("file:./in")
                .routeId("render file")
                .unmarshal().json(JsonLibrary.Gson, RenderRequest.class)
                .bean("reportingService", "render")
                .setBody(simple("${body.content}"))
                .setHeader("CamelFileName", simple("${header.CamelFileName}.pdf"))
                .to("file:./out")
                .log(LoggingLevel.INFO, "${body}")
                ;
    }
}
