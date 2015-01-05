package com.beci.service.response;

import com.beci.Encoding;
import com.beci.Utils;
import com.beci.service.exception.RequestResponseServiceException;

import com.beci.service.jms.mo.MOQueueSender;
import com.beci.service.transforms.MessageQueueTransform;
import com.thoughtworks.xstream.XStream;
import lombok.AccessLevel;
import lombok.Getter;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.util.stream.Collectors;

public class RequestResponseService {
    @Resource private MOQueueSender queueSender;
    @Resource private XStream xStream;
    @Resource protected MessageQueueTransform messageQueueTransform;
    @Resource protected Logger normalLogger;
    @Getter(AccessLevel.PROTECTED) private int length = 0;
    private String xml;

    public RequestResponseService() {

    }

    protected final void sentToMOQueue(final String message, final int priority){
        normalLogger.debug("sentToMOQueue(Message : {}, Priority : {})", message, priority);
        queueSender.send(message, priority);
    }

    protected final boolean getXMLFromHttpRequest(final HttpServletRequest request) throws RequestResponseServiceException{
        try {
            String message = request.getReader().lines().collect(Collectors.joining());
            if (!Utils.isEmpty(message)) {
                xml = URLDecoder.decode(message, Encoding.UTF_8.getEncoding()).trim().replaceFirst("^([\\W]+)<","<");
                normalLogger.debug("[XML FROM HTTP_REQUEST : {}]", xml);
            }
            return isSafety();
        } catch (Exception e) {
            normalLogger.error("Exception while getXMLFromHttpRequest() ", e);
            throw new RequestResponseServiceException(e);
        }
    }

    protected final void flushResponse(final HttpServletResponse response, final String xml, final Encoding encoding){
        normalLogger.debug("flushResponse()");
        try(
                ServletOutputStream servletOutputStream = response.getOutputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(xml.getBytes(encoding.getEncoding())));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(servletOutputStream)
        ) {
            byte[] buff = new byte[1024];
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(buff, 0, buff.length)) != -1) {
                bufferedOutputStream.write(buff, 0, bytesRead);
                bufferedOutputStream.flush();
            }
            servletOutputStream.flush();
        } catch (IOException e) {
            normalLogger.error("Exception while flushResponse() ", e);
        }
    }

    private boolean isSafety() {
        return !Utils.isEmpty(xml);
    }

    protected final Object getObjectFromXML(final Class c) throws RequestResponseServiceException{
        normalLogger.debug("getObjectFromXML(Class : {})", c.getName());
        try {
            xStream.processAnnotations(c);
            normalLogger.debug("[OBJECT FROM HTTP_REQUEST : {}]", xml);
            return xStream.fromXML(xml);
        } catch (Exception e) {
            normalLogger.error("Exception while getObjectFromXML() ", e);
            throw new RequestResponseServiceException(e);
        }
    }

    protected final String getXMLFromObject(final Class c, final Object o, final Encoding encoding) throws RequestResponseServiceException{
        normalLogger.debug("getXMLFromObject(Class : {}, Object : {}, Encoding : {})", c.getName(), o.toString(), encoding.getEncoding());
        try {
            xStream.processAnnotations(c);
            final String xml = StringEscapeUtils.unescapeXml(encoding.getEncodingHeadTag() + (xStream.toXML(o).replace("<?xml version=\"1.0\" ?>", "")));
            normalLogger.debug("[XML TO HTTP_RESPONSE : {}]", xml);
            length = xml.length();
            return xml;
        } catch (Exception e) {
            normalLogger.error("Exception while getXMLFromObject() ", e);
            throw new RequestResponseServiceException(e);
        }
    }
}
