package com.yzh9954.spring.boot.dubbo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@RestController
@SpringBootApplication
public class App1 {

    private static Logger logger = LoggerFactory.getLogger(App1.class);

    @RequestMapping("map1")
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "yzh");
        map.put("age", 27.1);
        return map;
    }

    // public static void main(String[] args) {
    // SpringApplication.run(App1.class, args);
    // }
}
