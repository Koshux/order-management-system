package com.lanzonprojects.omsapi.server;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.crnk.core.boot.CrnkBoot;
import io.crnk.home.HomeModule;
import io.crnk.meta.MetaModule;
import io.crnk.meta.MetaModuleConfig;
import io.crnk.meta.provider.resource.ResourceMetaProvider;
import io.crnk.servlet.CrnkServlet;
import io.crnk.spring.internal.SpringServiceDiscovery;
import io.crnk.validation.ValidationModule;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * @author lanzon-projects
 */
public class CrnkServletImpl extends CrnkServlet {

    @Override
    protected void initCrnk(CrnkBoot boot) {
        boot.setDefaultPageLimit(20L);
        boot.setWebPathPrefix("/api");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        boot.setObjectMapper(objectMapper);

        SpringServiceDiscovery springServiceDiscovery = new SpringServiceDiscovery();
        ApplicationContext appContext = WebApplicationContextUtils.findWebApplicationContext(getServletContext());

        if (appContext != null) {
            springServiceDiscovery.setApplicationContext(appContext);
        }

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        boot.addModule(ValidationModule.create(true, validator));
        boot.addModule(HomeModule.create());

        MetaModuleConfig metaModuleConfig = new MetaModuleConfig();
        metaModuleConfig.addMetaProvider(new ResourceMetaProvider());
        boot.addModule(MetaModule.createServerModule(metaModuleConfig));
    }
}
