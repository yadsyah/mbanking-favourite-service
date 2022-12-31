package id.co.diansetiyadi.favouriteservice.dto.request;

import id.co.diansetiyadi.favouriteservice.util.CategoryFavouriteEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseFavourite extends BaseRequest {

    private String cif;
    private String amount;
    private String accountNo;
    private String sourceOfFundAccount;
    private String billNo;
    private CategoryFavouriteEnum categoryFavouriteEnum;
    private String institutionCode;
}
