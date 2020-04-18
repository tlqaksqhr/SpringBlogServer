package com.semtax.application.config;

import com.semtax.application.interceptor.CommentAuthInterceptor;
import com.semtax.application.interceptor.LoginInterceptor;
import com.semtax.application.interceptor.PostAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebserviceConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Autowired
    PostAuthInterceptor postAuthInterceptor;

    @Autowired
    CommentAuthInterceptor commentAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/post/page")
                .addPathPatterns("/post/**")
                .addPathPatterns("/comment/**");

        registry.addInterceptor(postAuthInterceptor)
                .excludePathPatterns("/post/page")
                .excludePathPatterns("/post/**/comment/**")
                .addPathPatterns("/post/**");

        registry.addInterceptor(commentAuthInterceptor)
                .addPathPatterns("/post/**/comment/**");
    }
}
