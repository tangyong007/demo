package com.offcn.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send")
    public void send(String text){
        jmsMessagingTemplate.convertAndSend("offcn",text);
    }

    @RequestMapping("/sendMap")
    public void sendMap(){

        Map map = new HashMap();

        map.put("mobile","13452197850");

        map.put("content","恭喜获得10元代金券");

        jmsMessagingTemplate.convertAndSend("offcn_map",map);
    }
    @RequestMapping("/sendSms")
    public void sendSms(){
        Map map = new HashMap();

        map.put("mobile","13452197850");

        map.put("template_code","SMS_164575074");

        map.put("sign_name","躺一块");

        map.put("param","{\"code\":\"102931\"}");

        jmsMessagingTemplate.convertAndSend("sms",map);
    }
}
