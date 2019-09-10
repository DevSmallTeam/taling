package com.uxunchina.taling.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.controller
 * @date 2019-08-27 16:55
 */
@Slf4j
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @RequiresPermissions("system:view")
    public String index(Model model){
        log.debug("debug级别日志");
        log.error("错误日志-----");
        log.info("这个是请求日志哟");
        model.addAttribute("id","123");
        model.addAttribute("names","你好！");
        return "index";
    }

}