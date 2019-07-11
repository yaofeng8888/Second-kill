package com.yf.springsaveorder;

import com.yf.springsaveorder.config.propertysource.MyApplicationEnvironmentPreparedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringSaveorderApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringSaveorderApplication.class);
        springApplication.addListeners(new MyApplicationEnvironmentPreparedEventListener());
        springApplication.run(args);
    }

}
