package com.yzh9954.spring.boot.dubbo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duolabao.customer.shared.agent.api.model.AgentModel;
import com.yzh9954.spring.boot.dubbo.service.DubboService;

/**
 * Hello world!
 */
@RestController
@SpringBootApplication
public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    // @Reference(version = "1.0")
    @Autowired
    DubboService          dubboService;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public AgentModel hell() {
        logger.info("test hello.........");
        // dubboService.getMemberService().getCityCodeByCityName("北京");
        logger.info(dubboService.getMemberService().getProvinceCodeByProvinceName("北京"));
        return new com.duolabao.customer.shared.agent.api.model.AgentModel();
    }

    @RequestMapping("map")
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "yzh");
        map.put("age", 27);
        return map;
    }

    @RequestMapping("list")
    public List<AgentModel> getList() {
        List<AgentModel> list = new ArrayList<AgentModel>();
        list.add(new AgentModel());
        return list;
    }

    // @RequestMapping("view")
    // public ModelAndView getView() {
    // return new ModelAndView("");
    // }

    public static void main(String[] args) {
        SpringApplication.run(App1.class, args);
    }
}
