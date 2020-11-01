package io.github.kimmking.gateway.router;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author qzl
 * @create 2020/11/1
 */
public class HttpEndpointCustomerRouter implements HttpEndpointRouter{
    @Override
    public String route(List<String> endpoints) {
        System.out.println("经过路由器");
        // 根据请求的url，路由到具体的服务
        return null;
    }
}
