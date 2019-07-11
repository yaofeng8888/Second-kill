package com.yf.springorder;

import com.yf.springorder.config.propertysource.MyApplicationEnvironmentPreparedEventListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.yf.springorder.mapper")
public class SpringOrderApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringOrderApplication.class);
        springApplication.addListeners(new MyApplicationEnvironmentPreparedEventListener());
        springApplication.run(args);
    }
}
