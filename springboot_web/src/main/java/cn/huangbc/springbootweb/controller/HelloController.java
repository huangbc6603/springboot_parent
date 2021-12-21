package cn.huangbc.springbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangbc
 * @version 1.0
 * @date 2021/12/19 17:53
 */
@RestController
@RequestMapping("Test")
public class HelloController {

    @RequestMapping("sayHello")
    public String sayHello(){
        return "hello Word-------------hahaha";
    }

}
