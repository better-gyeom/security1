package com.cos.security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터체인에 등록이 된다.
public class SecurityConfig {

    @Bean //해당 메서드의 리턴되는 오브젝트를 IoC로 등록해준다.
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder(); //비밀번호 암호화
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(CsrfConfigurer::disable);

        http.formLogin((auth) -> auth.loginPage("/loginForm").permitAll()); //로그인 페이지로 이동하게 함

        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers("/user/**").authenticated() //인증 필요
                .requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER") //역할 필요
                .requestMatchers("/admin/**").hasAnyRole("ADMIN") //역할 필요
                .anyRequest().permitAll()); //그 외엔 모두 허용


        return http.build();
    }
}
