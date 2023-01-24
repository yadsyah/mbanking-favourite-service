package id.co.diansetiyadi.favouriteservice.event.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import id.co.diansetiyadi.favouriteservice.event.CreateFavouriteEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class FavouriteEventListener {
    
    @EventListener
    public void createFavouriteListener(CreateFavouriteEvent event) {
        log.info(this.getClass().getName() + ".createFavouriteListener Start");
        log.info("eventID", event.getEventId());
        log.info("CIF : " + event.getCif());
        log.info("EVENT", new Gson().toJson(event));
        log.info("CATEGORY_FAVOURITE : " + event.getCategoryFavouriteEnum());
    }
}
