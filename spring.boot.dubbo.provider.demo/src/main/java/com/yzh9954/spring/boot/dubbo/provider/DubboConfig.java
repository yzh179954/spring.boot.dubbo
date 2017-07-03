/*
 * Copyright 2013-2015 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */
package com.yzh9954.spring.boot.dubbo.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.rpc.Exporter;

/**
 * 类DubboConfig.java的实现描述：TODO 类实现描述
 *
 * @author yangzhihua 2017年6月30日 上午11:01:59
 */

@Configuration
@ConditionalOnClass(Exporter.class)
@PropertySource(value = "classpath:/dubbo.properties")
public class DubboConfig implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(DubboConfig.class);

    @Value("${dubbo.application.name}")
    private String              applicationName;

    @Value("${dubbo.registry.address}")
    private String              registryAddress;

    @Value("${dubbo.provider.timeout}")
    private int                 timeOut;

    @Value("${dubbo.provider.retries}")
    private int                 retries;

    @Value("${dubbo.protocol.name}")
    private String              protocolName;

    @Value("${dubbo.protocol.port}")
    private int                 protocolPort;

    @Value("${dubbo.provider.threads}")
    private int                 threads;

    private Environment         environment;

    public DubboConfig(Environment environment){
        this.environment = environment;
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
        System.out.println("test.....");
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
    @Bean
    public ProtocolConfig protocolConfig() {
        // 服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(protocolName);
        protocolConfig.setPort(protocolPort);
        protocolConfig.setThreads(threads);
        return protocolConfig;
    }

    /**
     * dubbo服务提供
     *
     * @param applicationConfig
     * @param registryConfig
     * @param protocolConfig
     * @return
     */
    @Bean(name = "defaultProvider")
    public ProviderConfig providerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig,
                                         ProtocolConfig protocolConfig) {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(timeOut);
        providerConfig.setRetries(retries);
        providerConfig.setDelay(-1);
        providerConfig.setApplication(applicationConfig);
        providerConfig.setRegistry(registryConfig);
        providerConfig.setProtocol(protocolConfig);
        return providerConfig;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        if (logger.isInfoEnabled()) {
            logger.info("dubbo spring provider init complete");
        }
    }

}
