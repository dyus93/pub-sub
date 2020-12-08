package ru.intech.pubsub.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import ru.intech.pubsub.persistence.entities.Message;
import ru.intech.pubsub.persistence.repository.MessageRepo;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.sql.Timestamp;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final JmsTemplate jmsTemplate;
    private final MessageRepo messageRepo;


    public void sendMessage(String queue, final String messageStr){
        jmsTemplate.send(queue, new MessageCreator() {
            @Override
            public javax.jms.Message createMessage(Session session) throws JMSException {
                ObjectMessage message = session.createObjectMessage(messageStr);
                log.info("message send");
                return message;
            }
        });
    }

    public Message generateMessage(){
        Message message = Message.builder()
                .msisdn(getRandomMsisdn())
                .action(getRandomAction())
                .timestamp(new Timestamp(System.currentTimeMillis()).getNanos())
                .build();
        log.info("new message generated");
        log.info("{}", message);
//        messageRepo.save(message);
        return message;
    }

    private String getRandomAction() {
        int a = (int)(Math.random() * 2);
        if (a == 0) {
            return "PURCHASE";
        }else
            return "SUBSCRIPTION";

    }

    private int getRandomMsisdn() {
        Random r = new Random();
        return r.nextInt();
    }
}
