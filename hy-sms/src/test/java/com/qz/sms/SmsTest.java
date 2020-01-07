package com.qz.sms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 齐桢
 * @site www.qz.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SmsTest {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void sendTest() {
        Map<String, String> map = new HashMap<>();
        map.put("phone", "16679094908");
        map.put("code", "88888");
        amqpTemplate.convertAndSend("wlkg.sms.exchange", "sms.verify.code", map);
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}