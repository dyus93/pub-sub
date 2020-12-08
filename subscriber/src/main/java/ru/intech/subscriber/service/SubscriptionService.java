package ru.intech.subscriber.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.intech.subscriber.persistance.entities.Subscription;
import ru.intech.subscriber.persistance.repository.SubscriptionRepo;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepo subscriptionRepo;

    public void save(UUID id){
        Subscription subscription = Subscription.builder()
                .messageId(id)
                .build();
        subscriptionRepo.save(subscription);
    }
}
