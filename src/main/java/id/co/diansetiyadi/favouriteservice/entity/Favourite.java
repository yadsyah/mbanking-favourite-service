package id.co.diansetiyadi.favouriteservice.entity;


import id.co.diansetiyadi.favouriteservice.util.CategoryFavouriteEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity(name = "Favourite")
@Table(name = "favourite")
public class Favourite extends BaseEntity{


    @Column(name = "cif", length = 16)
    private String cif;
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private CategoryFavouriteEnum categoryFavouriteEnum;
    @Column(name = "account_no", length = 20)
    private String accountNo;
    @Column(name = "institution_code", length = 20)
    private String institutionCode;
    @Column(name = "bill_no", length = 50)
    private String billNo;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "source_of_fund_account", length = 20)
    private String sourceOfFundAccount;
    @Column(name = "bank_code", length = 5)
    private String bankCode;
    @Column(name = "ccy", length = 20)
    private String ccy;

}
