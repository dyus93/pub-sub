package ru.intech.pubsub.persistence.entities;

import lombok.*;
import ru.intech.pubsub.persistence.entities.utils.PersistableEntity;

import javax.persistence.Entity;

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
