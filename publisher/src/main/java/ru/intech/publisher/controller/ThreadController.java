package ru.intech.pubsub.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import ru.intech.pubsub.service.MessageService;

//@Slf4j
//public class ThreadController implements Runnable{
//    private final MessageService messageService = new MessageService(new JmsTemplate());
//    private String name;
//    private Thread t;
//
//
//    public ThreadController(String name){
//        this.name = name;
//        this.t = new Thread(this);
//        log.info("Thread {} started", Thread.currentThread().getName());
//    }
//    @Override
//    public void run() {
//        for (int i = 0; i < 5; i++) {
//            try {
//                ObjectMapper mapper = new ObjectMapper();
//                String messageStr = mapper.writeValueAsString(messageService.generateMessage());
//                log.info("{}", messageStr);
//                messageService.sendMessage("queue", messageStr);
//                Thread.sleep(15000);
//                log.info("{}: sleeping", Thread.currentThread().getName());
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
