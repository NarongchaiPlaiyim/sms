package com.beci.controller;

import com.beci.service.operators.AisService;
import com.beci.service.operators.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestMapping("/ais")
public class AisController extends ControllerImpl implements OperatorController{
    @Autowired private OperatorService aisServiceImpl;
    @Value("#{config['operator.ais']}") private String operator;

    @Override
    public void onReceive(HttpServletRequest request, HttpServletResponse response) {
        super.process(request, response, aisServiceImpl, operator);
    }
}
