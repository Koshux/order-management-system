package com.lanzonprojects.omsapi.server;

import io.crnk.core.boot.CrnkProperties;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.annotation.ManagedBean;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * @author lanzon-projects.
 */
@ManagedBean
public class WebAppInitializer implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.setServletContext(servletContext);
//        servletContext.addListener(new ContextLoaderListener());
        servletContext.addListener(new RequestContextListener());

        ServletRegistration.Dynamic crnkServlet = servletContext.addServlet("crnkServlet", new CrnkServletImpl());
        crnkServlet.setInitParameter(CrnkProperties.WEB_PATH_PREFIX, "/jsonapi");
        crnkServlet.setInitParameter(CrnkProperties.ALLOW_UNKNOWN_ATTRIBUTES, "false");
        crnkServlet.setInitParameter(CrnkProperties.ALLOW_UNKNOWN_PARAMETERS, "false");
        crnkServlet.setInitParameter(CrnkProperties.RESOURCE_FIELD_IMMUTABLE_WRITE_BEHAVIOR, "FAIL");
        crnkServlet.setInitParameter(CrnkProperties.RETURN_404_ON_NULL, "true");
        crnkServlet.addMapping("/jsonapi/*");
    }
}
