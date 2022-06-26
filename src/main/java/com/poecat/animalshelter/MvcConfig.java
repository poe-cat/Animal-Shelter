package com.poecat.animalshelter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path photoUploadDir = Paths.get("./animal-photos");
        String photoUploadPath = photoUploadDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/animal-photos/**")
                .addResourceLocations("file:/" + photoUploadPath + "/");

        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/").resourceChain(false);
    }
}
