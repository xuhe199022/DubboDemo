package com.xcc.service;


import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public interface TicketService {
    public String getTicket();
}
