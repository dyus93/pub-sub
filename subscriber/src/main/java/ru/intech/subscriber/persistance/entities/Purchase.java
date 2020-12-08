package ru.intech.subscriber.persistance.entities;

import lombok.*;
import ru.intech.subscriber.persistance.entities.utils.PersistableEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Purchase extends PersistableEntity {

    @JoinColumn(name = "message_id")
    private UUID messageId;

}
