package com.xcc;

import com.xcc.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.xcc")
class ConsumerServerApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void test() {
        System.out.println(userService.buyTicket());
    }
}
