package com.beci.service.operators;

import com.beci.ContentType;
import com.beci.Encoding;
import com.beci.HeaderType;
import com.beci.service.exception.RequestResponseServiceException;
import com.beci.service.response.RequestResponseService;
import com.beci.service.xml.dtac.mobile.CpaMobileRequest;
import com.beci.service.xml.dtac.mobile.CpaResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service("dtacServiceImpl")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Transactional
public class DtacServiceImpl extends RequestResponseService implements OperatorService {
    @Value("#{config['mo.priority.dtac']}")
    private int priority;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) {
        try {
            if(getXMLFromHttpRequest(request)){

                CpaMobileRequest cpaMobileRequest = (CpaMobileRequest) getObjectFromXML(CpaMobileRequest.class);
                sentToMOQueue(messageQueueTransform.toQueue(cpaMobileRequest), priority);

                final String xml = getXMLFromObject(CpaResponse.class, messageQueueTransform.toResponse(cpaMobileRequest), Encoding.UTF_8);

                response.setStatus(com.beci.HttpStatus.OK.getStatus());
                response.setContentType(ContentType.TEXT_HTML.getType());
                response.setContentLength(getLength());
                response.setHeader(HeaderType.CONNECTION.getType(), HeaderType.CLOSE.getType());
                flushResponse(response, xml, Encoding.UTF_8);
            }
        } catch (RequestResponseServiceException e){
            normalLogger.error("[DTAC] RequestResponseServiceException : ", e.getMessage());
        } catch (Exception e) {
            normalLogger.error("[DTAC] Exception while process() ", e);
        }



    }
}
