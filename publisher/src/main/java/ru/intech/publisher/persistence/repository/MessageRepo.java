package ru.intech.pubsub.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.intech.pubsub.persistence.entities.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
}
