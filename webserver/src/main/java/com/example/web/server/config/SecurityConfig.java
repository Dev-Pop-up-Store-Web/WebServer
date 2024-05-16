package com.example.web.server.config;

import java.util.List;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.example.web.server.member.security.JwtAuthenticationFilter;
import com.example.web.server.member.security.JwtProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

	private final JwtProvider jwtProvider;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			// ID, Password 문자열을 Base64로 인코딩하여 전달하는 구조
			.csrf(AbstractHttpConfigurer::disable)
			// CORS 설정
			.cors(c -> {
					CorsConfigurationSource source = request -> {
						// Cors 허용 패턴
						CorsConfiguration config = new CorsConfiguration();
						config.setAllowedOrigins(
							List.of("*")
						);
						config.setAllowedMethods(
							List.of("*")
						);
						return config;
					};
					c.configurationSource(source);
				}
			)
			// Spring Security 세션 정책 : 세션을 생성 및 사용하지 않음
			.sessionManagement((sessionManagement) ->
				sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			// 조건별로 요청 허용/제한 설정
			.authorizeHttpRequests(authorizeRequests ->
				authorizeRequests
					.requestMatchers(String.valueOf(PathRequest.toStaticResources().atCommonLocations())).permitAll()
					.requestMatchers("/register", "/login", "/member").permitAll()
					.requestMatchers("/review/**").permitAll()

					.requestMatchers("/admin/**").hasRole("ADMIN")
					.requestMatchers("/member/**").hasRole("USER")
					.anyRequest().denyAll()
			)
			// JWT 인증 필터 적용
			.addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);


		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}

