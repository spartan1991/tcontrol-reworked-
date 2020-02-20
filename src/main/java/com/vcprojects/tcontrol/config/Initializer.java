package com.vcprojects.tcontrol.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

//@Configuration
//public class Initializer implements WebApplicationInitializer {
//
//    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
//    private static final String TMP_FOLDER = "D:/tmp";
//    private static final int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//
//        rootContext.register(JPAConfig.class);
//        rootContext.register(WebConfig.class);
//        rootContext.register(WebSecurityConfig.class); //10.02.2020
//
//        servletContext.addListener(new ContextLoaderListener(rootContext));
//
//        rootContext.setServletContext(servletContext);
//
//        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME,
//                new DispatcherServlet(rootContext));
//
//        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER,
//                MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
//
//        servlet.setMultipartConfig(multipartConfigElement);
//        servlet.addMapping("/");
//        servlet.setLoadOnStartup(1);
//    }
//} // Commented 20.02.2020

    @Configuration  // NEW // Added 20.02.2020
    public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

        private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
        private static final String TMP_FOLDER = "D:/tmp";
        private static final int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;

        @Override
        public void onStartup(ServletContext servletContext) throws ServletException {

            AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

            rootContext.register(JPAConfig.class);
            rootContext.register(WebConfig.class);
            rootContext.register(WebSecurityConfig.class); //10.02.2020

            servletContext.addListener(new ContextLoaderListener(rootContext));

            rootContext.setServletContext(servletContext);

            ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME,
                    new DispatcherServlet(rootContext));

            /*Добавление фильтра кодирования символов. Позволяет работать с русскими символами.*/
            FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter",
                    new CharacterEncodingFilter()); //18.02.2020

            encodingFilter.setInitParameter("encoding", "UTF-8"); //18.02.2020
            encodingFilter.setInitParameter("forceEncoding", "true"); //18.02.2020
            encodingFilter.addMappingForUrlPatterns(null, true, "/*"); //18.02.2020

            /* ******************************************************************************* */

            MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER,
                    MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);

            servlet.setMultipartConfig(multipartConfigElement);
            servlet.addMapping("/");
            servlet.setLoadOnStartup(1);
        }

    /**
     * added to load spring security filter in root context (created in onStartup())
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {WebSecurityConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }
}
