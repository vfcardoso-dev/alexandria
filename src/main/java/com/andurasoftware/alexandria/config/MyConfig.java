package com.andurasoftware.alexandria.config;

import com.andurasoftware.alexandria.config.valueobjects.EnvironmentValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MyConfig {

    @Autowired
    private Environment env;

    @Bean(name = "envData")
    public EnvironmentValues values() {
        EnvironmentValues eValues = new EnvironmentValues();
        eValues.setEnvironmentName(env.getProperty("spring.env.name"));
        eValues.setApplicationName(env.getProperty("spring.application.name"));
        eValues.setApplicationVersion(env.getProperty("spring.application.version"));

        return  eValues;
    }

}
