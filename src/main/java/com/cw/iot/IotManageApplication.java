package com.cw.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-09 22:21
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class IotManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(IotManageApplication.class, args);
    }
}
