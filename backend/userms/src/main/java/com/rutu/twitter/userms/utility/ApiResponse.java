package com.rutu.twitter.userms.utility;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class ApiResponse<T> extends ResponseEntity<T> {
    public <T> ApiResponse(T body, HttpStatusCode status) {
        super((MultiValueMap<String, String>) body, status);
    }
}
