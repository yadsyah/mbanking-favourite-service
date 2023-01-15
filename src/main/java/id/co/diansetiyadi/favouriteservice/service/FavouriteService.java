package id.co.diansetiyadi.favouriteservice.service;

import id.co.diansetiyadi.favouriteservice.dto.request.AddFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.request.DeleteFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.request.InquiryFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.request.UpdateFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.response.AddFavouriteResponse;
import id.co.diansetiyadi.favouriteservice.dto.response.DeleteFavouriteResponse;
import id.co.diansetiyadi.favouriteservice.dto.response.InquiryFavouriteResponse;
import id.co.diansetiyadi.favouriteservice.dto.response.UpdateFavouriteResponse;


public interface FavouriteService {

    AddFavouriteResponse addFavourite(AddFavouriteRequest request);
    DeleteFavouriteResponse deleteFavourite(DeleteFavouriteRequest request);
    UpdateFavouriteResponse updateFavourite(UpdateFavouriteRequest request);
    InquiryFavouriteResponse inquiryFavourite(InquiryFavouriteRequest request);
}
