package com.example.demo.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
@Slf4j

public class GlobalExceptionHandler {


    @ExceptionHandler(ResponseStatusException .class)
    public ResponseEntity<ApiError> HandlerResponseStatus(ResponseStatusException ex){
        String message =ex.getReason();

        if (message==null){
            message="请求处理失败";
        }
        ApiError body =new ApiError(ex.getStatusCode().value(),message);

        return ResponseEntity
                .status(ex.getStatusCode())
                .headers(ex.getHeaders())
                .body(body);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiError> HandlerMistypematch(
            MethodArgumentTypeMismatchException e
    ){
        ApiError body=new ApiError(
                400,
                "参数"+ e.getName()+"的格式不对"
        );

        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(PlanNotFoundException.class)
    public ResponseEntity<ApiError> HandlerPlanNotFound(
            PlanNotFoundException e
    ){
        ApiError body =new ApiError(404,e.getMessage());
        return ResponseEntity.status(404).body(body);
    }
}
