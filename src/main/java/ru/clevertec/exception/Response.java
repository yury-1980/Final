package ru.clevertec.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Response {


    private String errorMessage;

    //    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode = "40401";

    public Response(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Response(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
