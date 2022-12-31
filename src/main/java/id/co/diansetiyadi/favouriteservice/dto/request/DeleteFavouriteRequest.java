package id.co.diansetiyadi.favouriteservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeleteFavouriteRequest extends BaseRequest {

    @NotBlank(message = "field idFavourite must not be blank!")
    private String idFavourite;

}
