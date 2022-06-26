package com.xcc.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author xuhe
 * @PackageName:com.xcc.consumerserver.service
 * @ClassName:UserService
 * @Description:
 * @data 2022/4/11 23:57
 */
@Service
public class UserService{

  /*  public String buyTicket(){
        return "123";
    }*/

    @DubboReference
    TicketService ticketService;
    public String buyTicket(){
        return ticketService.getTicket();
    }
}
