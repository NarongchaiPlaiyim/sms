package com.beci.service.operators;

import com.beci.ContentType;
import com.beci.Encoding;
import com.beci.HeaderType;
import com.beci.HttpStatus;
import com.beci.service.authorization.AuthorizationBase64;
import com.beci.service.exception.AuthorizationBase64Exception;
import com.beci.service.exception.RequestResponseServiceException;
import com.beci.service.response.RequestResponseService;
import com.beci.service.xml.truemove.MessageMOMT;
import com.beci.service.xml.truemove.MessageReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Service("trueMoveServiceImpl")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Transactional(propagation= Propagation.REQUIRED)
public class TrueMoveServiceImpl extends RequestResponseService implements OperatorService {
    @Value("#{config['mo.priority.truemove']}") private int priority;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            normalLogger.debug("HEADER[{} : {}]", headerName, request.getHeader(headerName));
        }

        //load user and password from database.
        String authorization = request.getHeader("authorization");
        try {
            AuthorizationBase64 authorizationBase64 = new AuthorizationBase64("0101102156", "qWACgXb4");
            authorizationBase64.isAllowed(authorization);
            if(getXMLFromHttpRequest(request)){

                MessageMOMT messageMO = (MessageMOMT) getObjectFromXML(MessageMOMT.class);
                sentToMOQueue(messageQueueTransform.toQueue(messageMO), priority);

                final String xml = getXMLFromObject(MessageReply.class, messageQueueTransform.toResponse(messageMO), Encoding.UTF_8);
                response.setStatus(HttpStatus.OK.getStatus());
                response.setContentType(ContentType.TEXT_HTML.getType());
                response.setContentLength(getLength());
                response.setHeader(HeaderType.CONNECTION.getType(), HeaderType.CLOSE.getType());
                flushResponse(response, xml, Encoding.UTF_8);
            } else {
                //for some exception
            }
        } catch (AuthorizationBase64Exception e) {
            normalLogger.error("[TRUE MOVE] AuthorizationException : {}", e);
            throw e;
        } catch (RequestResponseServiceException e){
            normalLogger.error("[TRUE MOVE] RequestResponseServiceException : {}", e);
            throw e;
        }

    }
}
