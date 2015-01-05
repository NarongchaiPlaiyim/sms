package com.beci.service.operators;

import com.beci.service.response.RequestResponseService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service("aisServiceImpl")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Transactional
public class AisServiceImpl extends RequestResponseService implements OperatorService{
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }
}
