package com.example.configclientdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 当有请求/fresh节点的时候，会重新请求一次ConfigServer去拉取最新的配置文件
 * 请求/fresh需要有几点要求：1.加actuator的依赖 2.SpringCloud1.5以上需要设置 management.security.enabled=false
 * 这个Controller的作用是查看from这个key的值
 */
@Controller
@RefreshScope //开启更新功能
@RequestMapping("/api")
public class TestDemoController {

    @Value("${from}")
    private String fromValue;

    /**
     * 返回配置文件中的值
     */
    @RequestMapping(value = "/from", method = RequestMethod.GET)
    @ResponseBody
    public String returnFormValue() {
        return fromValue;
    }

}
