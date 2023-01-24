package id.co.diansetiyadi.favouriteservice.event.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import id.co.diansetiyadi.favouriteservice.event.CreateFavouriteEvent;
import id.co.diansetiyadi.favouriteservice.event.object.FavouriteEvent;
import id.co.diansetiyadi.favouriteservice.util.CategoryFavouriteEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class FavouriteEventPublisher {

    private final ApplicationEventPublisher publisher;

    public void createFavouriteEvent(final String cif, final CategoryFavouriteEnum categoryFavouriteEnum) {
        log.info(this.getClass().getName() + ".push create favourite event start!");
        log.info("cif : " + cif);
        log.info("userName : " + categoryFavouriteEnum);
        publisher.publishEvent(CreateFavouriteEvent.builder()
                .cif(cif)
                .categoryFavouriteEnum(categoryFavouriteEnum)
                .build());
    }
}
