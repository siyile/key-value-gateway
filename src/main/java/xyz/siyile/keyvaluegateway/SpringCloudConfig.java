package xyz.siyile.keyvaluegateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/key-value/**")
                        .filters(f -> f.rewritePath("/key-value/(?<segment>.*)", "/${segment}"))
                        .uri("lb://KEY-VALUE-SERVICE")
                        .id("keyValueModule"))
                .build();
    }
}
