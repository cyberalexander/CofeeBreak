package com.leonovich.cofeebreak.web.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * This class initialize spring dispatcher-servlet in web aplication.
 * Created by alexanderleonovich on 30.08.15.
 */
public class Initializer implements WebApplicationInitializer {

    // Set name to Servlet Dispatcher for mapping
    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    // Set name to encoding filter for mapping
    private static final String ENCODING_FILTER_NAME = "encoding-filter";

    /**
     * Initialize servlet when application on startup.
     * @param servletContext Get ServletContext.
     * @throws ServletException push ServletException in up.
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebAppConfig.class);
        ctx.register(SecurityConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));
        ctx.setServletContext(servletContext);

        Dynamic servlet = servletContext
                .addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

        FilterRegistration.Dynamic encodingFilter = servletContext
                .addFilter(ENCODING_FILTER_NAME, new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");

        FilterRegistration.Dynamic springSecurityFilterChain = servletContext
                .addFilter("springSecurityFilterChain", new DelegatingFilterProxy());
        springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");
    }
}
