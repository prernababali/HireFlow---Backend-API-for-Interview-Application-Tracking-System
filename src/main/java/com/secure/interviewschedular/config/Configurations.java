package com.secure.interviewschedular.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author prabhakar, @Date 14-11-2024
 */
@Configuration
public class Configurations {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }



}
