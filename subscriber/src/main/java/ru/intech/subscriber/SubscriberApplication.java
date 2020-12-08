package ru.intech.subscriber;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.intech.subscriber.service.MessageService;

@SpringBootApplication
public class SubscriberApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubscriberApplication.class, args);
    }

    @Bean
    CommandLineRunner lineRunner(MessageService messageService){
        return  args -> {
            ObjectMapper mapper = new ObjectMapper();

        };
    }
}
