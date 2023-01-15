package id.co.diansetiyadi.favouriteservice.service.impl;

import com.google.gson.Gson;
import id.co.diansetiyadi.favouriteservice.dto.request.AddFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.request.DeleteFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.request.InquiryFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.request.UpdateFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.response.AddFavouriteResponse;
import id.co.diansetiyadi.favouriteservice.dto.response.DeleteFavouriteResponse;
import id.co.diansetiyadi.favouriteservice.dto.response.InquiryFavouriteResponse;
import id.co.diansetiyadi.favouriteservice.dto.response.UpdateFavouriteResponse;
import id.co.diansetiyadi.favouriteservice.entity.Favourite;
import id.co.diansetiyadi.favouriteservice.handling.FavouriteNotFoundException;
import id.co.diansetiyadi.favouriteservice.repository.FavouriteRepository;
import id.co.diansetiyadi.favouriteservice.service.FavouriteService;
import id.co.diansetiyadi.favouriteservice.util.CategoryFavouriteEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService {


    private final FavouriteRepository favouriteRepository;
    private final Gson gson;

    @Autowired
    public FavouriteServiceImpl(FavouriteRepository favouriteRepository, Gson gson) {
        this.favouriteRepository = favouriteRepository;
        this.gson = gson;
    }


    @Override
    public AddFavouriteResponse addFavourite(AddFavouriteRequest request) {
        Favourite existFavourite = favouriteRepository.findByCifAndCategoryAndSourceOfAccountNo(request.getCif(), request.getCategoryFavouriteEnum(), request.getSourceOfFundAccount()).orElse(null);

        if (null != existFavourite) {
            Favourite favourite = favouriteRepository.findByCifAndCategoryAndSourceOfAccountNo(request.getCif(), request.getCategoryFavouriteEnum(), request.getSourceOfFundAccount()).orElseThrow(() -> new FavouriteNotFoundException("favourite not found!"));
            favourite.setAmount(new BigDecimal(request.getAmount()));
            favourite = favouriteRepository.save(favourite);
            return AddFavouriteResponse.builder().idFavourite(favourite.getId()).build();
        }

        Favourite newFavourite = new Favourite();
        newFavourite.setCategoryFavouriteEnum(request.getCategoryFavouriteEnum());
        newFavourite.setCif(request.getCif());
        newFavourite.setSourceOfFundAccount(request.getSourceOfFundAccount());
        newFavourite.setCcy(request.getCcy());

        if (CategoryFavouriteEnum.TRANSFER.equals(request.getCategoryFavouriteEnum())) {
            newFavourite.setAmount(new BigDecimal(request.getAmount()));
            newFavourite.setBankCode(request.getBankCode());
            newFavourite.setAccountNo(request.getAccountNo());
        }

        if (CategoryFavouriteEnum.BILL_PAYMENT.equals(request.getCategoryFavouriteEnum())) {
            newFavourite.setBillNo(request.getBillNo());
            newFavourite.setInstitutionCode(request.getInstitutionCode());
        }

        if (CategoryFavouriteEnum.BILL_TOPUP.equals(request.getCategoryFavouriteEnum())) {
            newFavourite.setAmount(new BigDecimal(request.getAmount()));
            newFavourite.setInstitutionCode(request.getInstitutionCode());
            newFavourite.setBillNo(request.getBillNo());
        }

        newFavourite = favouriteRepository.save(newFavourite);

        return AddFavouriteResponse.builder()
                .idFavourite(newFavourite.getId())
                .build();
    }

    @Override
    public DeleteFavouriteResponse deleteFavourite(DeleteFavouriteRequest request) {

        Favourite existFavourite = favouriteRepository.findById(request.getIdFavourite()).orElseThrow(() -> new FavouriteNotFoundException("favourite not found!"));
        favouriteRepository.delete(existFavourite);
        return DeleteFavouriteResponse.builder().idFavourite(request.getIdFavourite()).build();
    }

    @Override
    public UpdateFavouriteResponse updateFavourite(UpdateFavouriteRequest request) {
        Favourite exisFavourite = favouriteRepository.findById(request.getIdFavourite()).orElseThrow(() -> new FavouriteNotFoundException("favourite not found!"));
        exisFavourite.setAccountNo(request.getAccountNo());
        exisFavourite.setAmount(new BigDecimal(request.getAmount()));
        exisFavourite.setBillNo(request.getBillNo());
        exisFavourite.setBankCode(request.getBankCode());
        exisFavourite.setSourceOfFundAccount(request.getSourceOfFundAccount());
        favouriteRepository.save(exisFavourite);
        return UpdateFavouriteResponse.builder()
        .idFavourite(exisFavourite.getId())
        .build();
    }

    @Override
    public InquiryFavouriteResponse inquiryFavourite(InquiryFavouriteRequest request) {
        List<Favourite> favourites = favouriteRepository.findByCifAndCategory(request.getCif(), request.getCategoryFavouriteEnum());
        return InquiryFavouriteResponse.builder()
                .totalFavourite(favourites.size())
                .favouriteList(favourites)
                .build();
    }
}
