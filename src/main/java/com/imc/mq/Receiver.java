package com.imc.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author luoly
 * @date 2018/11/7 22:51
 * @description
 */
@Component
public class Receiver {
    @JmsListener(destination = "my-destination")
    public void  receivedMessage(String message){
        System.out.println("接收到-->"+message);
    }
}