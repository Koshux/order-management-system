package com.lanzonprojects.omsapi;

import com.lanzonprojects.omsapi.server.CrnkServletImpl;
import io.crnk.core.boot.CrnkProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

@SpringBootApplication(scanBasePackages = "com.lanzonprojects.omsapi")
public class DogBoxOMSApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DogBoxOMSApplication.class, args);
    }

    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.setServletContext(servletContext);
        servletContext.addListener(new ContextLoaderListener());
        servletContext.addListener(new RequestContextListener());

        ServletRegistration.Dynamic crnkServlet = servletContext.addServlet("crnkServlet", new CrnkServletImpl());
        crnkServlet.setInitParameter(CrnkProperties.WEB_PATH_PREFIX, "/jsonapi");
//        crnkServlet.setInitParameter(CrnkProperties.CONT, "http://localhost:8085/lanzonprojects");
        crnkServlet.setInitParameter(CrnkProperties.ALLOW_UNKNOWN_ATTRIBUTES, "false");
        crnkServlet.setInitParameter(CrnkProperties.ALLOW_UNKNOWN_PARAMETERS, "false");
        crnkServlet.setInitParameter(CrnkProperties.RESOURCE_FIELD_IMMUTABLE_WRITE_BEHAVIOR, "FAIL");
        crnkServlet.setInitParameter(CrnkProperties.RETURN_404_ON_NULL, "true");
        crnkServlet.addMapping("/jsonapi/*");
    }
}
