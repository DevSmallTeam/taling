package com.uxunchina.taling.common.handler;

import com.uxunchina.taling.common.entity.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.common.handler
 * @date 2019/10/28 17:23
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response, Exception ex) {
        log.error("捕获全局异常:{}", ex.getMessage());
        if(isAjax(request)){
            return ajaxException(ex, request, response);
        }
        else {
            return exceptionPD(ex,request);
        }

    }
    public boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null &&
                "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }

    public ModelAndView exceptionPD(Exception ex, HttpServletRequest request) {
        ModelAndView modelAndView=new ModelAndView();
        if(ex instanceof UnauthorizedException) {
            modelAndView.addObject("msg", "你还没有该访问权限，请联系管理员!");
            modelAndView.setViewName("error/403");
            return modelAndView;
        }
        else {
            modelAndView.addObject("msg", "服务器内部异常，请检查开发人员！");
            modelAndView.setViewName("error/500");
            return modelAndView;
        }

    }

    public DataResponse ajaxException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        if(ex instanceof UnauthorizedException) {
            return new DataResponse().code(403).message("您还没有操作此项的权限，请联系管理员！");
        }
        else {
            return new DataResponse().fail().message("服务器内部异常，请检查开发人员！");
        }
    }
}
