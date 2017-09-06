package com.panjianguo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by MicLee on 12/16/15.
 */
@SpringBootApplication
@EnableAsync
public class Application {
    private final Logger logger = LoggerFactory.getLogger(Application.class);

    @Resource
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void initApplication() {
        logger.info("默认环境参数：{}", Arrays.toString(environment.getDefaultProfiles()));
    }

    @PreDestroy
    public void destroyApplication() {
        logger.info("应用关闭.");
    }
}
