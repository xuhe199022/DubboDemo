package com.xcc.controller;

import com.xcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhe
 * @PackageName:com.xcc.consumerserver.controller
 * @ClassName:UserController
 * @Description:
 * @data 2022/4/12 0:01
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/test")
    public String test(){
        return userService.buyTicket();
    }
}
