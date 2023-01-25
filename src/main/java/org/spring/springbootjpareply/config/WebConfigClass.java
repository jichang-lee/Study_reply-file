package org.spring.springbootjpareply.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // spring setting implements 외부에서 로컬의 특정 폴더에 접근 인터페이스
public class WebConfigClass implements WebMvcConfigurer {

    String saveFile="file:///C:/saveFiles/"; //외부에서 접근 허용할 폴더 설정

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations(saveFile);

    }
}
