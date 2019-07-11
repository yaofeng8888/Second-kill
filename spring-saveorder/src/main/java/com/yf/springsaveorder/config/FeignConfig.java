package com.yf.springsaveorder.config;//package com.xq.paas.config;
//
//import com.netflix.loadbalancer.BestAvailableRule;
//import com.netflix.loadbalancer.IRule;
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.nio.charset.Charset;
//import java.util.Base64;
//
//@Configuration
//public class FeignConfig implements RequestInterceptor {
//
//    @Override
//    public void apply(RequestTemplate templates) {
//        String auth = "admin:admin"; // 认证的原始信息
//        byte[] encodedAuth = Base64.getEncoder()
//                .encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
//        // 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
//        String authHeader = "Basic " + new String(encodedAuth);
//        templates.header("Authorization",authHeader);
//    }
//
//    @Bean
//    public IRule myRule(){
//        return new BestAvailableRule();
//    }
//
////    @Bean
////    public Feign.Builder feignHystrixBuilder() {
////        return HystrixFeign.builder().setterFactory((target, method) -> HystrixCommand.Setter
////                .withGroupKey(HystrixCommandGroupKey.Factory.asKey(UploadService.class.getSimpleName()))// 控制 RemoteProductService 下,所有方法的Hystrix Configuration
////                .andCommandPropertiesDefaults(
////                        HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000) // 超时配置
////                ));
////    }
//
//}
