package com.pragma.plazoleta.infrastructure.configuration;

import com.pragma.plazoleta.domain.api.IMessageServicePort;
import com.pragma.plazoleta.infrastructure.adapters.output.TwilioService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final TwilioService twilioService;

    @Bean
    public IMessageServicePort messageServicePort() {
        return twilioService;
    }
}