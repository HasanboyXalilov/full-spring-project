package com.company.fullspringbootproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {

    private boolean success;
    private String message;
    /*
    *  0 it is ok
    * -1 not found
    * -2 db error
    * -3 valid error
    */
    private int code;
    private T data;

}
