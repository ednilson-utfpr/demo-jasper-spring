package com.mballem.curso.jasper.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {

    private String from;
    private String to;
    private String subject;
    private Map<String, Object> model;
}
