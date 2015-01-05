package com.beci.controller;

import com.beci.service.operators.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestMapping(value = "/true", produces= MediaType.TEXT_XML_VALUE)
public class TrueMoveController extends ControllerImpl  implements OperatorController{
    @Autowired private OperatorService trueMoveServiceImpl;
    @Value("#{config['operator.true']}") private String operator;

    @Override
    public void onReceive(HttpServletRequest request, HttpServletResponse response) {
        super.process(request, response, trueMoveServiceImpl, operator);
    }
}



//    don't delete.
//    @Autowired
//    @Qualifier("trueMoveServiceImpl")
//    OperatorService trueMoveServiceImpl;