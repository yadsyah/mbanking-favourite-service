package id.co.diansetiyadi.favouriteservice.dto.response;

import id.co.diansetiyadi.favouriteservice.entity.Favourite;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class InquiryFavouriteResponse {

    private int totalFavourite;
    List<Favourite> favouriteList;
}
