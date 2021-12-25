package com.example.dubbo3customer.controller;

import com.example.dubbo3provider.DemoService;
import com.example.dubbo3provider.HelloReply;
import com.example.dubbo3provider.HelloRequest;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luhaoyuan
 * @date 2021/12/25
 * @desc
 */
@RestController
public class DemoController {

    @DubboReference(id = "demoService", version = "1.0.0")
    private DemoService demoService;

    @GetMapping("/")
    public String demo(@RequestParam String name) {

        HelloRequest helloRequest = HelloRequest.newBuilder().setName(name).build();
        HelloReply helloReply = demoService.sayHello(helloRequest);

        return helloReply.getMessage();
    }
}
