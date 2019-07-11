package com.yf.springbuy;

import com.yf.springbuy.config.propertysource.MyApplicationEnvironmentPreparedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringBuyApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringBuyApplication.class);
        springApplication.addListeners(new MyApplicationEnvironmentPreparedEventListener());
        springApplication.run(args);
    }

}
