package com.example.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.mail")
@Data
public class mailSendProperties {
    private String host;
    private int port;
    private String username;
    private String password;
}
