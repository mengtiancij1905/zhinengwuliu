package com.hy.exception;
import com.hy.dto.ExceptionResult;
import com.hy.dto.HyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResult> handlerException(HyException e){

        ExceptionResult result=new ExceptionResult(e.getExceptionEnums());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);

    }

}
