package com.secure.interviewschedular.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Properties;

/**
 * @author prabhakar, @Date 16-11-2024
 */
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "spring.mail")
public class EmailConfiguration {

    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private int port;
    @Value("${spring.mail.username}")
    private String userName;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.smtp.connectiontimeout}")
    private int connectionTimeOut;
    @Value("${spring.mail.smtp.timeout}")
    private int timeout;
    @Value("${spring.mail.smtp.witetimeout}")
    private int witetimeout;
    @Value("${spring.mail.smtp.auth}")
    private boolean auth;
    @Value("${spring.mail.smtp.starttls.enable}")
    private boolean startTTLEnable;
    @Value("${spring.mail.debug}")
    private boolean debug;
    @Value("${spring.mail.smtp.ssl.enable}")
    private boolean ssLEnable;


    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(userName);
        mailSender.setPassword(password);

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol","smtp");
        properties.put("mail.smtp.auth",auth);
        properties.put("mail.smtp.starttls.enable",startTTLEnable);
        properties.put("mail.debug",debug);
        properties.put("mail.smtp.ssl.enable",ssLEnable);
        return mailSender;
    }

   /* public ITemplateResolver thymleafTemplateResolver(){
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");

    }*/


}
