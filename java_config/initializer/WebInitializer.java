package <some_package>;

import javax.servlet.*;
import org.springframework.web.*;
import org.springframework.web.context.support.*;
import org.springframework.web.servlet.*;

public class WebInitializer implements WebApplicationInitializer
{
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException
  {
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//    ctx.register(BusinessConfig.class, LanguageConfig.class, MvcViewConfig.class, MailConfig.class, DeviceConfig.class, SitePreffConfig.class);
    ctx.setConfigLocation("com.pureshots.config");
    ctx.setServletContext(servletContext);

    ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));

    servlet.setLoadOnStartup(1);
    servlet.setAsyncSupported(true);
    servlet.addMapping("/");
  }
}
