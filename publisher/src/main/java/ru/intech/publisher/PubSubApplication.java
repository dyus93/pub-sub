package ru.intech.pubsub;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class PubSubApplication {

    public static void main(String[] args) {
        log.info("mainThread started");
        SpringApplication.run(PubSubApplication.class, args);

//        Thread t1 = new Thread(new ThreadController("One"));
//        Thread t2 = new Thread(new ThreadController("Second"));
//        Thread t3 = new Thread(new ThreadController("Third"));
//        Thread t4 = new Thread(new ThreadController("Fourth"));
//        Thread t5 = new Thread(new ThreadController("Fifth"));
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
    }
}
