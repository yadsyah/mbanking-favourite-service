package id.co.diansetiyadi.favouriteservice.dto.request;

import id.co.diansetiyadi.favouriteservice.util.CategoryFavouriteEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InquiryFavouriteRequest extends BaseRequest {

    @NotBlank(message = "field idFavourite must not be blank!")
    private String idFavourite;
    @NotBlank(message = "field cif must not be blank!")
    private String cif;
    @NotNull(message = "field categoryFavouriteEnum must not be blank!")
    private CategoryFavouriteEnum categoryFavouriteEnum;
}
