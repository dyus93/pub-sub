package ru.intech.subscriber.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.intech.subscriber.persistance.entities.Purchase;
import ru.intech.subscriber.persistance.repository.PurchaseRepo;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepo purchaseRepo;

    public void save(UUID id){
        Purchase purchase = Purchase.builder()
                .messageId(id)
                .build();
        purchaseRepo.save(purchase);
    }
}
