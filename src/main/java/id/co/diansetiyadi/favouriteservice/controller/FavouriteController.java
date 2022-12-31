package id.co.diansetiyadi.favouriteservice.controller;

import id.co.diansetiyadi.favouriteservice.dto.request.AddFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.request.DeleteFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.request.InquiryFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.request.UpdateFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.response.BaseResponse;
import id.co.diansetiyadi.favouriteservice.service.FavouriteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class FavouriteController {

    private final FavouriteService favouriteService;

    @Autowired
    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }


    @PostMapping("/add")
    @ResponseBody
    public Mono<BaseResponse> addFavourite(@RequestBody @Valid AddFavouriteRequest addFavouriteRequest) {
        return Mono.just(BaseResponse.builder().build());
    }

    @PostMapping("/delete")
    @ResponseBody
    public Mono<BaseResponse> deleteFavourite(@RequestBody @Valid DeleteFavouriteRequest request) {
        return Mono.just(BaseResponse.builder().build());
    }

    @PostMapping("/update")
    @ResponseBody
    public Mono<BaseResponse> updateFavourite(@RequestBody @Valid UpdateFavouriteRequest request) {
        return Mono.just(BaseResponse.builder().build());
    }

    @PostMapping("/inquiry")
    @ResponseBody
    public Mono<BaseResponse> inquiryFavourite(@RequestBody @Valid InquiryFavouriteRequest request) {
        return Mono.just(BaseResponse.builder().build());
    }
}
