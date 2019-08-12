package com.concurrent.demo.springtest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "test")
public class TestProperties {
    private String server_address;
    private TestProperties.Config config;

    public String getServer_address() {
        return server_address;
    }

    public void setServer_address(String server_address) {
        this.server_address = server_address;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public static class Config{
        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
