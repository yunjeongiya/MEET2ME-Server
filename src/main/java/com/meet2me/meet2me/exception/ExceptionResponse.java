package com.meet2me.meet2me.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String requestUrl;
    private String requestBody;
    private String errorMessage;
}

