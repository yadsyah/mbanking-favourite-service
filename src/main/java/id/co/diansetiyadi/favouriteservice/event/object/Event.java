package id.co.diansetiyadi.favouriteservice.event.object;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Event {
    
    private final UUID eventId;
    private final LocalDate createAt;

    public Event(LocalDate createAt) {
        this.eventId = UUID.randomUUID();
        this.createAt = createAt;
    }

    


}
