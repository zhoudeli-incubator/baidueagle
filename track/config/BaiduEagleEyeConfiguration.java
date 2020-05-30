package com.chinavisionary.link.app.track.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(BaiduEagleEyeProperties.class)
public class BaiduEagleEyeConfiguration {

    public static final RestTemplate REST_TEMPLATE = new RestTemplate();
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Bean
    public RestTemplate restTemplate(){
        return REST_TEMPLATE;
    }

    @Bean
    public ObjectMapper objectMapper(){
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return OBJECT_MAPPER;
    }
}
