package org.example.jsreport;

import net.jsreport.java.JsReportException;
import net.jsreport.java.dto.*;
import net.jsreport.java.service.JsReportService;
import net.jsreport.java.service.JsReportServiceImpl;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

public class Main {
    public static void main ( String [] arguments )
    {
        JsReportService reportingService = new JsReportServiceImpl("http://localhost:5488");
        RenderStatelessReport(reportingService);
        RenderPersistedTemplate(reportingService);
        System.out.println("Done");
    }

    private static void RenderStatelessReport (JsReportService reportingService) {
        Template template = new Template();
        template.setContent("Hello world from {{message}}");
        template.setEngine(Engine.HANDLEBARS);
        template.setRecipe(Recipe.CHROME_PDF);

        HashMap data = new HashMap();
        data.put("message", "java");

        RenderRequest renderRequest = new RenderRequest(template, data);

        try {
            Report report = reportingService.render(renderRequest);
            Files.copy(report.getContent(), Paths.get("report1.pdf"), StandardCopyOption.REPLACE_EXISTING);
        } catch (JsReportException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void RenderPersistedTemplate (JsReportService reportingService) {
        try {
            Report report = reportingService.render("invoice-main", null);
            Files.copy(report.getContent(), Paths.get("report2.pdf"), StandardCopyOption.REPLACE_EXISTING);
        } catch (JsReportException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
