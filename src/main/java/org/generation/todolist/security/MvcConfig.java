package org.generation.todolist.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

//https://spring.io/guides/gs/securing-web/

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        //map the browser's URL to a specific View (HTML) inside resources/templates directory
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/todoform").setViewName("todoform");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/images")
//        .addResourceLocations("classpath:/static/", "classpath:/images/")
//        .setCachePeriod(0);
//    }
}
