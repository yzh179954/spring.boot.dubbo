/*
 * Copyright 2013-2015 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */
package com.yzh9954.spring.boot.dubbo.config.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;

/**
 * 类DubboConfig.java的实现描述：TODO 类实现描述
 * 
 * @author yangzhihua 2017年6月30日 上午11:01:59
 */

@Configuration
@PropertySource(value = "classpath:/dubbo.properties")
public class DubboConfig implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(DubboConfig.class);

    @Value("${dubbo.application.name}")
    private String              applicationName;

    @Value("${dubbo.registry.address}")
    private String              registryAddress;

    // @Value("${dubbo.provider.timeout}")
    // private int timeOut;

    private Environment         environment;

    public DubboConfig(Environment environment){
        this.environment = environment;
    }

    /**
     * 
     */
    public DubboConfig(){
        // TODO Auto-generated constructor stub
    }

    /**
     * 设置dubbo扫描包
     * 
     * @param packageName
     * @return
     */
    @Bean
    public static AnnotationBean annotationBean(@Value("${dubbo.annotation.package}") String packageName) {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(packageName);
        return annotationBean;
    }

    /**
     * 注入dubbo上下文
     * 
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        // 当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(this.applicationName);
        return applicationConfig;
    }

    /**
     * 注入dubbo注册中心配置,基于zookeeper
     * 
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        // registry.setProtocol(protocol);
        registry.setAddress(registryAddress);
        return registry;
    }

    /**
     * 默认基于dubbo协议提供服务
     * 
     * @return
     */
    // @Bean
    // public ProtocolConfig protocolConfig() {
    // // 服务提供者协议配置
    // ProtocolConfig protocolConfig = new ProtocolConfig();
    // // protocolConfig.setName(protocolName);
    // // protocolConfig.setPort(protocolPort);
    // protocolConfig.setThreads(200);
    // System.out.println("默认protocolConfig：" + protocolConfig.hashCode());
    // return protocolConfig;
    // }

    /**
     * dubbo服务提供
     * 
     * @param applicationConfig
     * @param registryConfig
     * @param protocolConfig
     * @return
     */
    // @Bean(name = "defaultProvider")
    public ProviderConfig providerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig,
                                         ProtocolConfig protocolConfig) {
        ProviderConfig providerConfig = new ProviderConfig();
        // providerConfig.setTimeout(timeout);
        // providerConfig.setRetries(retries);
        // providerConfig.setDelay(delay);
        providerConfig.setApplication(applicationConfig);
        providerConfig.setRegistry(registryConfig);
        providerConfig.setProtocol(protocolConfig);
        return providerConfig;
    }

    /**
     * 声明为dubbo消费者配置
     * 
     * @param applicationConfig
     * @param registryConfig
     * @param protocolConfig
     * @return
     */
    @Bean(name = "defaultConsumer")
    public ConsumerConfig consumerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig) {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setVersion("2.5.3");
        consumerConfig.setRegistry(registryConfig);
        consumerConfig.setApplication(applicationConfig);
        consumerConfig.setLoadbalance("roundrobin");
        consumerConfig.setTimeout(2000);
        consumerConfig.setRetries(3);

        return consumerConfig;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        if (logger.isInfoEnabled()) {
            logger.info("dubbo spring consumer init complete");
        }
    }

    // public String getApplicationName() {
    // return applicationName;
    // }
    //
    // public void setApplicationName(String applicationName) {
    // this.applicationName = applicationName;
    // }
    //
    // public String getRegistryAddress() {
    // return registryAddress;
    // }
    //
    // public void setRegistryAddress(String registryAddress) {
    // this.registryAddress = registryAddress;
    // }

}
