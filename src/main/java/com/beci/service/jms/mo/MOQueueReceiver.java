package com.beci.service.jms.mo;
import com.beci.service.jms.mt.MTQueueSender;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

@Service("moQueueReceiver")
public class MOQueueReceiver implements MessageListener{
    @Resource protected Logger normalLogger;
    private MTQueueSender mtQueueSender;

    private MOQueueReceiver(final MTQueueSender mtQueueSender) {
        this.mtQueueSender = mtQueueSender;
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String msgText = ((TextMessage) message).getText();
                normalLogger.debug("onMessage(Message : {})", msgText);
                mtQueueSender.send(msgText, message.getJMSPriority());
            } catch (JMSException e){
                normalLogger.error("An error occurred extracting message ", e);
            }
        }
    }
}
