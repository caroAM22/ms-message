package com.pragma.plazoleta.infrastructure.configuration;

import com.pragma.plazoleta.domain.spi.INotificationServicePort;
import com.pragma.plazoleta.infrastructure.adapters.output.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final NotificationService notificationService;

    @Bean
    public INotificationServicePort notificationServicePort() {
        return notificationService;
    }
}