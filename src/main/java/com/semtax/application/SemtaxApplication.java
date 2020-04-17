package com.semtax.application;

import com.semtax.application.util.Sessions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
public class SemtaxApplication {
    public static void main(String[] args) {
        SpringApplication.run(SemtaxApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            ServletRequestAttributes attr
                = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

            String currentUser = (String)attr.getRequest().getSession().getAttribute(Sessions.SESSION_ID);

            if(currentUser != null)
                return Optional.of(currentUser);
            else
                return Optional.of("Anonymous");
        };
    };
}
