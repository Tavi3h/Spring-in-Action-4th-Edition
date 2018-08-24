package spittr.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

public class MyServletInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // 注册Servlet

//         ServletRegistration.Dynamic myServlet =
//         servletContext.addServlet("myServlet", MyServlet.class);
//        
//         myServlet.addMapping("/custom/home");

        // 注册DispatcherServlet并设定Multipart请求
        
//        DispatcherServlet ds = new DispatcherServlet();
//
//        ServletRegistration.Dynamic registration = servletContext.addServlet("springmvc", ds);
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");
//        registration.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads"));
    }
}
