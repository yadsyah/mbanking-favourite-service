package id.co.diansetiyadi.favouriteservice.dto.response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse {

    private String traceId;
    private String responseCode;
    private String message;
    private Object data;


}
