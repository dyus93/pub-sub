package ru.intech.subscriber.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.intech.subscriber.persistance.entities.Subscription;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {
}
