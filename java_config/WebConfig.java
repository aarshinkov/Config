package com.pureshots.config;

import javax.servlet.*;
import org.springframework.web.*;
import org.springframework.web.context.support.*;
import org.springframework.web.servlet.*;

public class WebConfig implements WebApplicationInitializer
{
  public void onStartup(ServletContext container) throws ServletException
  {
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.register(AppConfig.class);
    ctx.setServletContext(container);

    ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

    servlet.setLoadOnStartup(1);
    servlet.addMapping("/");
  }
}
