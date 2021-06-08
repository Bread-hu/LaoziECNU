package com.laozi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    static final String[] ORIGINS = new String[]{"GET", "POST", "PUT", "DELETE"};  //请求方式

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //所有的当前站点的请求地址，都支持跨域访问
                .allowedOriginPatterns("*")    // 所有的外部域都可跨域访问,这里注意2.4.0以后是allowedOriginPatterns，以前是allowedOrigins
                .allowCredentials(true)  //是否支持跨域用户凭证
                .allowedMethods(ORIGINS) //当前站点支持的跨域请求类型是什么
                .maxAge(3600);  //超是时长，单位为秒。
    }
}
