package com.beci.service.jms.mo;

import com.beci.Utils;
import lombok.Synchronized;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

@Service("moQueueSender")
public class MOQueueSender {
    @Resource private Logger normalLogger;
    private Session session;
    private MessageProducer messageProducer;

    private MOQueueSender(Session session, MessageProducer messageProducer) {
        this.session = session;
        this.messageProducer = messageProducer;
    }

    public @Synchronized void send(final String message, final int priority){
        TextMessage textMessage = null;
        try {
            textMessage = session.createTextMessage(message);
            messageProducer.setPriority(priority);
            messageProducer.send(textMessage);
        } catch (JMSException e) {
            System.out.println(e);
        } finally {
            if(Utils.isNull(textMessage)){
                try {
                    textMessage.clearBody();
                    textMessage.clearProperties();
                } catch (JMSException e) {
                    normalLogger.error("JMSException : ", e);
                }
            }
        }
    }
}
