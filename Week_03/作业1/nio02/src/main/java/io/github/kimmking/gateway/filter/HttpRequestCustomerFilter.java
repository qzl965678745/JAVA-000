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
        HttpHeaders headers = fullRequest.headers();
        headers.set("nio","quzhilin");

        String uri = fullRequest.uri();
        System.out.println("经过过滤器,url="+uri);

    }
}
