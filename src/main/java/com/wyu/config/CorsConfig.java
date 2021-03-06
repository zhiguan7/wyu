package com.wyu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    /**
     * 解决异步访问跨域
     */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            // 设置允许跨域的路由
            registry.addMapping("/**")
                    // 设置允许跨域请求的域名
                    .allowedOriginPatterns("*")
                    // 是否允许证书（cookies）
                    .allowCredentials(true)
                    // 设置允许的方法
                    .allowedMethods("*")
                    //设置缓存时间，减少重复响应
                    .maxAge(3600);
        }
}


