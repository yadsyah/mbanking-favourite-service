package id.co.diansetiyadi.favouriteservice.entity;


import id.co.diansetiyadi.favouriteservice.util.CategoryFavouriteEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Favourite {


    private String cif;
    private CategoryFavouriteEnum categoryFavouriteEnum;
    private String accountNo;
    private String institutionCode;
    private String billNo;
    private String amount;
    private String sourceOfFundAccount;

}
