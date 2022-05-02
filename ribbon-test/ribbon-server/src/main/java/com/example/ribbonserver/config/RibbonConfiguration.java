package com.example.ribbonserver.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class RibbonConfiguration {

    final IClientConfig ribbonClientConfig;

    @Bean
    public IRule rule() {
        return new AvailabilityFilteringRule();
    }
}
