package com.rtstjkx.jkx.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultException(HttpServletRequest httpServletRequest, Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Exception",e);
        modelAndView.addObject("url",httpServletRequest.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
