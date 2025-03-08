package com.dev.jbs.ecommerce.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasicResponse {

    private Integer status;
    private Object data;
    private String message;
    private Object metadata;
}
