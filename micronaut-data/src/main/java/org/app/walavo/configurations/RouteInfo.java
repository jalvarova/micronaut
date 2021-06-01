package org.app.walavo.configurations;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteInfo {
    private String uri;
    private String method;
    private String consumes;
    private String produces;

    public RouteInfo(String uri,String method, String consumes,String produces) {
        this.uri = uri;
        this.method = method;
        this.consumes = consumes;
        this.produces = produces;
    }
}
