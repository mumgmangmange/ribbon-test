package com.example.ribbonserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@RibbonClient(name = "demo1-service", configuration = RibbonConfiguration.class) //
@RibbonClients({
        @RibbonClient(name = "demo1"),
        @RibbonClient(name = "demo2")
})
public class RibbonServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonServerApplication.class, args);
    }

    @LoadBalanced // 로드밸런싱 사용 -> 인터셉터에 의해 yml 정의 정보를 찾아 호출해줌
    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
