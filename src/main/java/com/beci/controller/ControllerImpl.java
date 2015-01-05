package com.beci.controller;

import com.beci.service.operators.OperatorService;

import org.slf4j.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerImpl {
    @Resource protected Logger normalLogger;

    public void process(HttpServletRequest request, HttpServletResponse response, OperatorService operatorService, String operator){
        normalLogger.debug("[{}] MO Started.", operator);
        try {
            operatorService.process(request, response);
            normalLogger.debug("[{}] MO Stopped.", operator);
        } catch (Exception e) {
            normalLogger.debug("[{}] MO Stopped By Exception.", operator, e);
        }
    }
}
