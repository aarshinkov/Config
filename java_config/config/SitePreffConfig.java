package com.pureshots.config;

import java.util.*;
import org.springframework.context.annotation.*;
import org.springframework.mobile.device.*;
import org.springframework.mobile.device.site.*;
import org.springframework.web.method.support.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.pureshots")
public class SitePreffConfig extends WebMvcConfigurerAdapter
{
  @Bean
  public DeviceResolverHandlerInterceptor
          deviceResolverHandlerInterceptor()
  {
    return new DeviceResolverHandlerInterceptor();
  }

  @Bean
  public SitePreferenceHandlerInterceptor
          sitePreferenceHandlerInterceptor()
  {
    return new SitePreferenceHandlerInterceptor();
  }

  @Bean
  public SitePreferenceHandlerMethodArgumentResolver
          sitePreferenceHandlerMethodArgumentResolver()
  {
    return new SitePreferenceHandlerMethodArgumentResolver();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry)
  {
    registry.addInterceptor(sitePreferenceHandlerInterceptor());
  }

  @Override
  public void addArgumentResolvers(
          List<HandlerMethodArgumentResolver> argumentResolvers)
  {
    argumentResolvers.add(sitePreferenceHandlerMethodArgumentResolver());
  }
}
