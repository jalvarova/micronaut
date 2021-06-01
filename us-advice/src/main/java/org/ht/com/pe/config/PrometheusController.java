package org.ht.com.pe.config;


import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.micronaut.configuration.metrics.annotation.RequiresMetrics;
import io.micronaut.configuration.metrics.management.endpoint.MetricsEndpoint;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.management.endpoint.annotation.Endpoint;
import io.micronaut.management.endpoint.annotation.Read;

@Endpoint(value="metrics",id = "metrics",defaultSensitive = false)
@Replaces(MetricsEndpoint.class)
@RequiresMetrics
public class PrometheusController {

    private final PrometheusMeterRegistry meterRegistry;

    PrometheusController(PrometheusMeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Read
    String index() {
        return meterRegistry.scrape();
    }
}
