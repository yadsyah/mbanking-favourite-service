package id.co.diansetiyadi.favouriteservice.dto.request;

import id.co.diansetiyadi.favouriteservice.util.CategoryFavouriteEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateFavouriteRequest extends BaseRequest {

    private String idFavourite;
    private String cif;
    private String amount;
    private CategoryFavouriteEnum categoryFavouriteEnum;
    private String sourceOfFundAccount;
    private String accountNo;
    private String billNo;
    private String bankCode;
}
