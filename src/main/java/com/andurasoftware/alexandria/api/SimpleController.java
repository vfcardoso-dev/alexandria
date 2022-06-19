package com.andurasoftware.alexandria.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @Value("${app.name}") String appName;
    @Value("${app.environment}") String envName;

    @GetMapping("/test")
    public GenericEntity test() {
        return new GenericEntity(appName, envName);
    }

    static class GenericEntity {
        public String appName;
        public String envName;

        public GenericEntity(String appName, String envName) {
            this.appName = appName;
            this.envName = envName;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getEnvName() {
            return envName;
        }

        public void setEnvName(String envName) {
            this.envName = envName;
        }
    }
}