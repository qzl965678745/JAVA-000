package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author qzl
 * @create 2020/11/1
 */
public class HttpRequestCustomerFilter implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) throws Exception {
        String uri = fullRequest.uri();
        if(!uri.contains("/hello")){
            System.out.println("无权限");
            throw new  Exception();
        }
        System.out.println("经过过滤器");
    }
}
