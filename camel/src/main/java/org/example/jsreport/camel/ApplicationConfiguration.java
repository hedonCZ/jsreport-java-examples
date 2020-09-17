package org.example.jsreport.camel;

import net.jsreport.java.service.JsReportService;
import net.jsreport.java.service.JsReportServiceImpl;
import org.apache.camel.BindToRegistry;
import org.apache.camel.PropertyInject;

public class ApplicationConfiguration {

    @BindToRegistry
    public JsReportService reportingService(@PropertyInject(value = "serverUrl") String serverUrl) {
        return new JsReportServiceImpl(serverUrl);
    }
}
