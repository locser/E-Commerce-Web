package com.locser.ecommerce.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws  Exception {
        httpSecurity.authorizeRequests(configurer ->
                    configurer.antMatchers("/api/orders/**")
                            .authenticated())
                .oauth2ResourceServer()
                .jwt();

        httpSecurity.cors();

        //add content negotiation strategy
        httpSecurity.setSharedObject(ContentNegotiationStrategy.class,
                new HeaderContentNegotiationStrategy());

        //force a non-empty response bodt for 401
        Okta.configureResourceServer401ResponseBody(httpSecurity);

        return httpSecurity.build();
    }

}
