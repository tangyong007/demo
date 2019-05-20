package com.offcn.demo.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Consumer {

    @JmsListener(destination = "offcn")

    public void readMessage(String text){
        System.out.println("接收到消息："+text);
    }

    @JmsListener(destination = "offcn_map")

    public void redMap(Map map){
        System.out.println(map);
    }
}
