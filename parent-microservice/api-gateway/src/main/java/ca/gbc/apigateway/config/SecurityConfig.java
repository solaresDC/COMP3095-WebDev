package ca.gbc.apigateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final String[] noauthResourcesUris = {
            "/swagger-ui",
            "/swagger-ui/*",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/api-docs/**",
            "/aggregate/**"
    };
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{



        log.info("Initializing security Filter Chain...");

        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable) //disable CSRF protection
        //        .authorizeHttpRequests(authorize -> authorize
        //                .anyRequest().authenticated())  //all request temporarily permitted -> get around autentification

                //ypu can only choose one either auth... up or auth.. down

                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(noauthResourcesUris)
                        .permitAll()//bypass authntification -> !!!!!THIS IS ONLY FOR DEVELPMENT YOU NEVER EVER USE THIS IN PRODUCTS
                        .anyRequest().authenticated())  //all request require authentication
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults()))
                .build();

    }
}
