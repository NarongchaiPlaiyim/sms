package com.beci.service.operators;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OperatorService {
    public void process(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
