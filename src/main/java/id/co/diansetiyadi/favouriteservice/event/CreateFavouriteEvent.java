package id.co.diansetiyadi.favouriteservice.event;

import java.time.LocalDate;

import id.co.diansetiyadi.favouriteservice.event.enums.EventType;
import id.co.diansetiyadi.favouriteservice.event.object.FavouriteEvent;
import id.co.diansetiyadi.favouriteservice.util.CategoryFavouriteEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
public final class CreateFavouriteEvent extends FavouriteEvent {

    private final String cif;
    private final CategoryFavouriteEnum categoryFavouriteEnum;

    @Builder
    public CreateFavouriteEvent(LocalDate createAt, EventType eventType, String cif,
            CategoryFavouriteEnum categoryFavouriteEnum) {
        super(createAt, eventType);
        this.cif = cif;
        this.categoryFavouriteEnum = categoryFavouriteEnum;
    }

    
    
}
