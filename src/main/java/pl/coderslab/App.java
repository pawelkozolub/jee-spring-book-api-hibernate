package pl.coderslab;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import pl.coderslab.configuration.AppConfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Application initializer class to start up application
 * that implements WebApplicationInitializer to use onStartup method
 *
 */
public class App implements WebApplicationInitializer
{

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // application context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);        // AppConfig class is registered
        context.setServletContext(container);     // servlet context is set -> container
        // creating and setting of DispatcherServlet
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher",
                new DispatcherServlet(context));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        // filter definition for UTf-8 encoding
        FilterRegistration.Dynamic filterRegistration = container.addFilter("encodingFilter",
                new CharacterEncodingFilter());
        filterRegistration.setInitParameter("encoding", "UTF-8");
        filterRegistration.setInitParameter("forcedEncoding", "true");
        filterRegistration.addMappingForUrlPatterns(null, true, "/*");
    }
}
