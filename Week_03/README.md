学习笔记

服务端：
1.绑定了一个8888端口，映射到http://localhost:8088
2.添加了一个HttpInboundHandler 处理器，用于读取请求url
3.添加一个HttpOutboundHandler，通过httpclient异步访问刚刚读取的url
4.通过CloseableHttpAsyncClient获取返回的response

客户端：
绑定了一个8088端口，通过HttpServerHandler处理接收到的请求
