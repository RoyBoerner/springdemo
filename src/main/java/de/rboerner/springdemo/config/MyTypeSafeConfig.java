package de.rboerner.springdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.net.URL;
import java.time.Duration;
import java.util.List;

@Data
@Component
@Validated
@ConfigurationProperties(prefix = "config")
public class MyTypeSafeConfig {

    private boolean enabled;

    @NotNull
    private URL serviceUrl;

    @Valid
    private Security security;

    private Duration sessionTimeout;

    @Data
    public static class Security {

        @NotEmpty
        private String username;

        @NotEmpty
        private String password;

        private List<String> roles;
    }

}
