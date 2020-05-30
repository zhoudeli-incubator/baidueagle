package com.chinavisionary.link.app.track.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CaseFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

public class RequestParameterUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static URI requestUrlForGet(String url, Object source) {
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            Map<String, Object> convertMap = (Map<String, Object>)objectMapper.convertValue(source, Map.class);
            convertMap.forEach((k, v) -> builder.queryParam(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, k), String.valueOf(v)));

            return builder.build().encode().toUri();
        }catch (Exception e){
            return URI.create(url);
        }
    }


    public static HttpEntity requestEntityForGet() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            return new HttpEntity(headers);
        }catch (Exception e){
            return null;
        }
    }


    public static HttpEntity requestEntityForPost(Object source) {
        try {
            HttpHeaders headers = new HttpHeaders();
            // 表单提交
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
            Map<String, Object> convertMap = (Map<String, Object>)objectMapper.convertValue(source, Map.class);
            convertMap.forEach((k, v) -> params.add(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, k), String.valueOf(v)));

            return new HttpEntity(params, headers);
        }catch (Exception e){
            return null;
        }
    }
}
