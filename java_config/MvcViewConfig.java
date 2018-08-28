package com.pureshots.config;

import java.util.*;
import nz.net.ultraq.thymeleaf.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.dialect.*;
import org.thymeleaf.extras.springsecurity4.dialect.*;
import org.thymeleaf.spring4.*;
import org.thymeleaf.spring4.templateresolver.*;
import org.thymeleaf.spring4.view.*;
import org.thymeleaf.templateresolver.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.pureshots")
public class MvcViewConfig extends WebMvcConfigurerAdapter {

    //да се смени с WebMvcConfigurer interface as of version 5.0
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/pages/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        Set<ITemplateResolver> templateResolvers = new HashSet();
        templateResolvers.add(cltr());
        templateResolvers.add(srtr());

        Set<IDialect> additionalDialects = new HashSet();
        additionalDialects.add(layoutDialect());
        additionalDialects.add(securityDialect());

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolvers(templateResolvers);
        templateEngine.setAdditionalDialects(additionalDialects);
        return templateEngine;
    }

    @Bean
    public ClassLoaderTemplateResolver cltr() {
        ClassLoaderTemplateResolver cltr = new ClassLoaderTemplateResolver();
        cltr.setCheckExistence(true);
        cltr.setCacheable(false);
        cltr.setPrefix("/mail/");
        cltr.setTemplateMode("HTML");
        cltr.setCharacterEncoding("UTF-8");
        cltr.setOrder(1);
        return cltr;
    }

    @Bean
    public SpringResourceTemplateResolver srtr() {
        SpringResourceTemplateResolver srtr = new SpringResourceTemplateResolver();
        srtr.setPrefix("/WEB-INF/pages/");
        srtr.setSuffix(".html");
        srtr.setTemplateMode("HTML");
        srtr.setCharacterEncoding("UTF-8");
        srtr.setCacheable(false);
        srtr.setOrder(2);
        return srtr;
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");

        return viewResolver;
    }
}
