package com.beci.service.transforms;


import com.beci.DescriptionType;
import com.beci.NumberType;
import com.beci.RsrType;
import com.beci.Status;
import com.beci.service.xml.dtac.mobile.CpaMobileRequest;
import com.beci.service.xml.dtac.mobile.CpaResponse;
import com.beci.service.xml.truemove.MessageMOMT;
import com.beci.service.xml.truemove.MessageReply;
import com.beci.service.xml.truemove.reply.*;
import com.beci.service.xml.truemove.reply.Number;
import org.springframework.stereotype.Service;

@Service("messageQueueTransform")
public class MessageQueueTransform extends Transform{
    public String toQueue(final MessageMOMT mo){
        normalLogger.debug("[TRUE MOVE] toMessageQueue[{}]", mo.toString());
        MessageReply reply = new MessageReply();
        reply.setId(mo.getId());
        Rsr rsr = new Rsr();
        rsr.setType(RsrType.REPLY.getType());
        rsr.setServiceId(mo.getSms().getServiceId());

        Address address = new Address();
        Number number = new Number();
        Destination destination = new Destination();
        destination.setMessageId(mo.getSms().getDestination().getMessageId());
        if(NumberType.ABBREVIATED.isEquals(mo.getSms().getDestination().getAddress().getNumber().getType())){
            number.setType(NumberType.ABBREVIATED.getType());
            number.setContent(mo.getSms().getDestination().getAddress().getNumber().getContent());
            address.setNumber(number);
            destination.setAddress(address);
            rsr.setDestination(destination);
        }

        address = new Address();
        number = new Number();
        Source source = new Source();
        if(NumberType.INTERNATIONAL.isEquals(mo.getSms().getSource().getAddress().getNumber().getType())){
            number.setType(NumberType.INTERNATIONAL.getType());
            number.setContent(mo.getSms().getSource().getAddress().getNumber().getContent());
            address.setNumber(number);
            source.setAddress(address);
            rsr.setSource(source);
        }

        RsrDetail rsrDetail = new RsrDetail();
        rsrDetail.setStatus(Status.SUCCESS.getStatus());
        rsrDetail.setCode("0");
        rsrDetail.setDescription(DescriptionType.SUCCESS_RECEIVE_REQUEST.getType());
        rsr.setRsrDetail(rsrDetail);
        reply.setRsr(rsr);
        return reply.toString();
    }
    public String toQueue(final CpaMobileRequest mo){
        normalLogger.debug("[DTAC] toMessageQueue[{}]", mo.toString());
        return mo.toString();
    }


    public MessageReply toResponse(final MessageMOMT mo){
        normalLogger.debug("[TRUE MOVE] toResponse[{}]", mo.toString());
        MessageReply reply = new MessageReply();
        reply.setId(mo.getId());
        Rsr rsr = new Rsr();
        rsr.setType(RsrType.REPLY.getType());
        rsr.setServiceId(mo.getSms().getServiceId());

        Address address = new Address();
        Number number = new Number();
        Destination destination = new Destination();
        destination.setMessageId(mo.getSms().getDestination().getMessageId());
        if(NumberType.ABBREVIATED.isEquals(mo.getSms().getDestination().getAddress().getNumber().getType())){
            number.setType(NumberType.ABBREVIATED.getType());
            number.setContent(mo.getSms().getDestination().getAddress().getNumber().getContent());
            address.setNumber(number);
            destination.setAddress(address);
            rsr.setDestination(destination);
        }

        address = new Address();
        number = new Number();
        Source source = new Source();
        if(NumberType.INTERNATIONAL.isEquals(mo.getSms().getSource().getAddress().getNumber().getType())){
            number.setType(NumberType.INTERNATIONAL.getType());
            number.setContent(mo.getSms().getSource().getAddress().getNumber().getContent());
            address.setNumber(number);
            source.setAddress(address);
            rsr.setSource(source);
        }

        RsrDetail rsrDetail = new RsrDetail();
        rsrDetail.setStatus(Status.SUCCESS.getStatus());
        rsrDetail.setCode("0");

//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < 1000000; i++) {
//            stringBuilder.append(DescriptionType.SUCCESS_RECEIVE_REQUEST.getType());
//        }
//        rsrDetail.setDescription(stringBuilder.toString());

        rsrDetail.setDescription(DescriptionType.SUCCESS_RECEIVE_REQUEST.getType());

        rsr.setRsrDetail(rsrDetail);
        reply.setRsr(rsr);
        normalLogger.debug("[TRUE MOVE] MessageReply[{}]", reply.toString());
        return reply;
    }
    public CpaResponse toResponse(final CpaMobileRequest mo){
        normalLogger.debug("[DTAC] toResponse[{}]", mo.toString());
        CpaResponse response = new CpaResponse();
        response.setTxId(mo.getTxId());
        response.setStatus("200");
        response.setStatusDescription(DescriptionType.SUCCESS.getType());
        return response;
    }
}
