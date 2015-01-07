package com.beci.controller;

import com.beci.service.operators.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestMapping("/ais")
public class AisControllerImpl implements OperatorController{
    @Autowired private OperatorService aisServiceImpl;
    @Resource private Controller controller;
    @Value("#{config['operator.ais']}") private String operator;

    @Override
    public void onReceive(HttpServletRequest request, HttpServletResponse response) {
        controller.process(request, response, aisServiceImpl, operator);
    }
}
