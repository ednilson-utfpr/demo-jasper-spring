package com.mballem.curso.jasper.spring.service;

import com.mballem.curso.jasper.spring.model.Mail;

public interface EmailService {
    void sendEmail(Mail mail);
}
