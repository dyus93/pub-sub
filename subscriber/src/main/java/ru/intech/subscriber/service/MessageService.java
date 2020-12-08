package ru.intech.subscriber.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import ru.intech.subscriber.persistance.entities.Message;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final SubscriptionService subscriptionService;
    private final PurchaseService purchaseService;


    @JmsListener(destination = "queue")
    public void receiveMessage(String message) throws Exception{
        log.info("message received: {}", message);
        ObjectMapper objectMapper = new ObjectMapper();
        Message jsonToMessage = objectMapper.readValue(message, Message.class);
        log.info("message json formatting to object");
        if (jsonToMessage.getAction().equals("PURCHASE")){
            purchaseService.save(jsonToMessage.getId());
            log.info("message saved in purchase table");
        }else if (jsonToMessage.getAction().equals("SUBSCRIPTION")){
            subscriptionService.save(jsonToMessage.getId());
            log.info("message saved in subscription table");
        }
    }


}
