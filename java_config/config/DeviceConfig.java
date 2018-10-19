package <some_package>;

import java.util.*;
import org.springframework.context.annotation.*;
import org.springframework.mobile.device.*;
import org.springframework.web.method.support.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class DeviceConfig extends WebMvcConfigurerAdapter
{
  @Bean
  public DeviceResolverHandlerInterceptor
          deviceResolverHandlerInterceptor()
  {
    return new DeviceResolverHandlerInterceptor();
  }

  @Bean
  public DeviceHandlerMethodArgumentResolver
          deviceHandlerMethodArgumentResolver()
  {
    return new DeviceHandlerMethodArgumentResolver();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry)
  {
    registry.addInterceptor(deviceResolverHandlerInterceptor());
  }

  @Override
  public void addArgumentResolvers(
          List<HandlerMethodArgumentResolver> argumentResolvers)
  {
    argumentResolvers.add(deviceHandlerMethodArgumentResolver());
  }
}
