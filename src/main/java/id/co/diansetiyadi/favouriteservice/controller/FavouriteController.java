package id.co.diansetiyadi.favouriteservice.controller;

import id.co.diansetiyadi.favouriteservice.dto.request.AddFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.request.DeleteFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.request.InquiryFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.request.UpdateFavouriteRequest;
import id.co.diansetiyadi.favouriteservice.dto.response.BaseResponse;
import id.co.diansetiyadi.favouriteservice.service.FavouriteService;
import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FavouriteController {

    private final FavouriteService favouriteService;

    @Autowired
    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @PostMapping("/add")
    @ResponseBody
    public Mono<BaseResponse> addFavourite(@RequestBody @Valid AddFavouriteRequest addFavouriteRequest) {
        return Mono.just(BaseResponse.builder()
        .responseCode("00")
        .message("Success")
        .traceId(UUID.randomUUID().toString())
        .data(favouriteService.addFavourite(addFavouriteRequest))
        .build());
    }

    @PostMapping("/delete")
    @ResponseBody
    public Mono<BaseResponse> deleteFavourite(@RequestBody @Valid DeleteFavouriteRequest request) {
        return Mono.just(BaseResponse.builder()
        .responseCode("00")
        .message("Success")
        .traceId(UUID.randomUUID().toString())
        .data(favouriteService.deleteFavourite(request))
        .build());
    }

    @PostMapping("/update")
    @ResponseBody
    public Mono<BaseResponse> updateFavourite(@RequestBody @Valid UpdateFavouriteRequest request) {
        return Mono.just(BaseResponse.builder()
        .message("Success")
        .traceId(UUID.randomUUID().toString())
        .data(favouriteService.updateFavourite(request))
        .build());
    }

    @PostMapping("/inquiry")
    @ResponseBody
    public Mono<BaseResponse> inquiryFavourite(@RequestBody @Valid InquiryFavouriteRequest request) {
        return Mono.just(BaseResponse.builder()
        .responseCode("00")
        .message("Success")
        .traceId(UUID.randomUUID().toString())
        .data(favouriteService.inquiryFavourite(request))
        .build());
    }
}
