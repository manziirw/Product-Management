//package com.Product.ProductManagement.Config;
//
//import com.Product.ProductManagement.converter.StringToLocalDateConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new StringToLocalDateConverter());
//    }
//
//    @Bean
//    public ServletRegistrationBean<DispatcherServlet> dispatcherRegistration(DispatcherServlet dispatcherServlet) {
//        ServletRegistrationBean<DispatcherServlet> registration = new ServletRegistrationBean<>(dispatcherServlet);
//        registration.getUrlMappings().clear();
//        registration.addUrlMappings("/api/*");
//        return registration;
//    }
//}
//
