package ru.intech.subscriber.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.intech.subscriber.persistance.entities.Purchase;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Long> {

}
