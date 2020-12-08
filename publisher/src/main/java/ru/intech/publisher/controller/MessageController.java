
package ru.intech.pubsub.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.intech.pubsub.service.MessageService;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class MessageController{
    private final JmsTemplate jmsTemplate;
    private final MessageService messageService;

    @JsonFormat
    @RequestMapping(value = "/send", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public String send(){
        jmsTemplate.send(new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    objectMapper.writeValueAsString(messageService.generateMessage());
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                ObjectMessage objectMessage = session.createObjectMessage(objectMapper);
                log.info("json: {}", objectMessage);
                return objectMessage;
            }
        });
        return "message send";
    }
}
