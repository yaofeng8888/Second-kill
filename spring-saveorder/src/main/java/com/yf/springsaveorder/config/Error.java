package com.yf.springsaveorder.config;



import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Error extends AbstractErrorController {
    public Error(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
