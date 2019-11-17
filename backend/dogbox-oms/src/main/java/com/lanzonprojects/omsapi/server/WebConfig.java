package com.lanzonprojects.omsapi.server;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lanzon-projects.
 */
@Configuration
public class WebConfig {

    @Bean
    public ServletRegistrationBean<CrnkServletImpl> crnkServlet() {
        ServletRegistrationBean<CrnkServletImpl> servRegBean = new ServletRegistrationBean<>();
        servRegBean.setServlet(new CrnkServletImpl());
        servRegBean.addUrlMappings("/jsonapi/*");
        servRegBean.setLoadOnStartup(1);
        return servRegBean;
    }
}
