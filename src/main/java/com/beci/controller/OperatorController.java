package com.beci.controller;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OperatorController {
    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
    @Transactional(propagation = Propagation.REQUIRED/*, isolation = Isolation.READ_COMMITTED*/)
    public void onReceive(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
