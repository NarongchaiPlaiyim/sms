package com.beci.service.jms.mt;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Service("mtQueueReceiver")
public class MTQueueReceiver implements MessageListener{
    @Resource private Logger normalLogger;
    private MTQueueSender queueSender;

    @SuppressFBWarnings({"URF_UNREAD_FIELD"})
    private MTQueueReceiver(final MTQueueSender queueSender) {
//        this.queueSender = queueSender;
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String msgText = ((TextMessage) message).getText();
                normalLogger.debug("onMessage(Message : {})", msgText);
            } catch (JMSException e){
                normalLogger.error("An error occurred extracting message ", e);
            }
        }
    }
}
