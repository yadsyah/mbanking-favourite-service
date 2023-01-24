package id.co.diansetiyadi.favouriteservice.event.object;

import java.time.LocalDate;
import java.util.UUID;

import id.co.diansetiyadi.favouriteservice.event.enums.EventType;
import lombok.Getter;

@Getter
public abstract class FavouriteEvent extends Event {

    private final EventType eventType;

    public FavouriteEvent(LocalDate createAt, EventType eventType) {
        super(createAt);
        this.eventType = eventType;
    }

    
    
}
