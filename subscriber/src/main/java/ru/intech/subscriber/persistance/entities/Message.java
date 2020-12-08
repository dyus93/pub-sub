package ru.intech.subscriber.persistance.entities;

import lombok.*;
import ru.intech.subscriber.persistance.entities.utils.PersistableEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Message extends PersistableEntity {

    private int msisdn;
    private String action;
    private int timestamp;
}