package com.xcc.service;

import org.apache.dubbo.config.annotation.DubboService;


/**
 * @author xuhe
 * @PackageName:com.xcc.prioviderserver.service
 * @ClassName:TicketService
 * @Description:
 * @data 2022/4/11 20:37
 */
@DubboService
public class TicketServiceImp implements TicketService {
    @Override
    public String getTicket() {
        return "xcc get ticket123";
    }
}
