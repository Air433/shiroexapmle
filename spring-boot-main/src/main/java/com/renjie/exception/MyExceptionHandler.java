package com.renjie.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ouyanggang on 2018/5/18.
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

  public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
      Exception e) {
    return null;
  }
}
