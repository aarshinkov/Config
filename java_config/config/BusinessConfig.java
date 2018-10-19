package <some_package>;

import org.springframework.context.annotation.*;
import org.springframework.context.support.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class BusinessConfig
{
  @Bean
  public ReloadableResourceBundleMessageSource messageSource()
  {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasenames("classpath:messages/messages"); //classpath:folder/file 
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
}
