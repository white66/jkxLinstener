package com.rtstjkx.jkx.config;

import com.rtstjkx.jkx.filter.MyFilter;
import com.rtstjkx.jkx.filter.MyInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.servlet.Filter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    MyInterceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(myInterceptor).addPathPatterns("/show");
    }

    @Bean
    public FilterRegistrationBean filterRegistration(MyFilter myFilter){
        FilterRegistrationBean<Filter> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter(myFilter);
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setName("myFilter");
        filterRegistration.setOrder(1);
        return filterRegistration;
    }
}
