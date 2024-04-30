package ua.com.kneu.course_admin_shop_np_2024.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry reg) {
       reg.
               addResourceHandler("/static/**")
               .addResourceLocations("classpath:/static/");
    }
}
