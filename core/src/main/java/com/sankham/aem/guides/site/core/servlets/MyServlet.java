package com.sankham.aem.guides.site.core.servlets;

import com.sankham.aem.guides.site.core.services.MyService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(
    service = Servlet.class,
    property = {
            "sling.servlet.methods=" + HttpConstants.METHOD_POST,
            "sling.servlet.resourceTypes=" + "sling/servlet/default",
            "sling.servlet.selectors=" + "myServlet",
            "sling.servlet.extensions=" + "json"
    }
)
public class MyServlet extends SlingAllMethodsServlet {

    @Reference (target = "(country=in)")
    public MyService myService;

    public static final Logger LOGGER = LoggerFactory.getLogger(MyServlet.class);

    protected void doPost(SlingHttpServletRequest request , SlingHttpServletResponse response)
        throws ServletException, IOException {

        LOGGER.debug("Servlet Test Complete!!");
        String retVal = myService.printLogger();
        LOGGER.debug(retVal);
    }
}
