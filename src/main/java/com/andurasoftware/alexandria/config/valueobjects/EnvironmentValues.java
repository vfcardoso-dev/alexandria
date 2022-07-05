package com.andurasoftware.alexandria.config.valueobjects;


public class EnvironmentValues {

    private String applicationName;
    private String applicationVersion;
    private String environmentName;

    public String getApplicationName() { return this.applicationName; }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }
}
