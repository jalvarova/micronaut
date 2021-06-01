package org.app.walavo.configurations;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.management.endpoint.annotation.Endpoint;
import io.micronaut.management.endpoint.annotation.Read;
import io.micronaut.management.endpoint.routes.RouteDataCollector;
import io.micronaut.web.router.Router;
import io.micronaut.web.router.UriRoute;
import io.reactivex.Single;

import javax.inject.Singleton;
import java.util.Comparator;
import java.util.stream.Stream;

@Singleton
@Replaces(io.micronaut.management.endpoint.routes.RoutesEndpoint.class)
@Endpoint("routes")
public class RoutesEndpoint {

    private final Router router;

    private final RouteDataCollector routeDataCollector;

    public RoutesEndpoint(Router router, RouteDataCollector routeDataCollector) {
        this.router = router;
        this.routeDataCollector = routeDataCollector;
    }

    /**
     * @return The routes as a {@link Single}
     */
    @Read
    public Stream<RouteInfo> getRoutes() {
        Stream<RouteInfo> uriRoutes = router.uriRoutes()
                .sorted(Comparator
                        .comparing((UriRoute r) -> r.getUriMatchTemplate().toPathString())
                        .thenComparing((UriRoute r) -> r.getHttpMethod().ordinal()))
                .map((UriRoute route)-> {
                    return new RouteInfo(route.getUriMatchTemplate().toPathString(),route.getHttpMethod().toString(),route.getConsumes().toString(),route.getProduces().toString());
                });

        return uriRoutes;
    }
}
