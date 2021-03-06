package com.cqszw.demo.config;



import com.cqszw.demo.Component.LoginHandlerInterceptor;
import com.cqszw.demo.Component.MyLocaleResolve;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class MyConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/dashboard.html").setViewName("dashboard");
        registry.addViewController("/about.html").setViewName("about");
        registry.addViewController("/visitor/about.html").setViewName("visitor/about");
    }
//注册拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/meetings/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/meeting/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/users/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/user/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/dashboard/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/about/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/table/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/newslist/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/news/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/papers/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/paper/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/downloads/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/uploads/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/search/**");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

    }
    @Bean
    public  LocaleResolver localeResolver(){
        return new MyLocaleResolve();
    }
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter hiddenHttpMethodFilter=new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setBeanName("HiddenHttpMethodFilter");
        hiddenHttpMethodFilter.setMethodParam("_method");
        return hiddenHttpMethodFilter;
    }



}
