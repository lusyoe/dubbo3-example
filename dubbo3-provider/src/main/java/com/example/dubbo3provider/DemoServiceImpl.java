package com.example.dubbo3provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * @author luhaoyuan
 * @date 2021/12/25
 * @desc
 */
@DubboService(version = "1.0.0")
public class DemoServiceImpl implements com.example.dubbo3provider.DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public com.example.dubbo3provider.HelloReply sayHello(com.example.dubbo3provider.HelloRequest request) {
        logger.info("Hello " + request.getName() + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return com.example.dubbo3provider.HelloReply.newBuilder()
                .setMessage("Hello " + request.getName() + ", response from provider: "
                        + RpcContext.getContext().getLocalAddress())
                .build();
    }

    @Override
    public CompletableFuture<com.example.dubbo3provider.HelloReply> sayHelloAsync(com.example.dubbo3provider.HelloRequest request) {
        return CompletableFuture.completedFuture(sayHello(request));
    }
}
