/*
 * Copyright 2013-2015 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */
package com.yzh9954.spring.boot.dubbo.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.duolabao.customer.shared.api.service.AreaQueryService;

/**
 * 类DubboService.java的实现描述：TODO 类实现描述
 * 
 * @author yangzhihua 2017年6月30日 下午1:02:41
 */
@Component
public class DubboService {

    @Reference(version = "1.0")
    AreaQueryService areaQueryService;

    public AreaQueryService getMemberService() {
        return this.areaQueryService;
    }

}
