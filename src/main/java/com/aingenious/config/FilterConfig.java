package com.aingenious.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aingenious.filter.JwtAuthenticationFilter;

@Configuration
public class FilterConfig {
	@Autowired
	JwtAuthenticationFilter authFilter;
    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> expiringSetFilter() {
        FilterRegistrationBean<JwtAuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(authFilter);
        registrationBean.addUrlPatterns("/*"); // Apply to all URLs
        return registrationBean;
    }
}

