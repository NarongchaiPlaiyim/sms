package com.beci.service.xml.truemove.momt;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("ussd_session")
public class UssdSession {
    @XStreamAlias("transaction_no")
    private String transactionNo;

    @XStreamAlias("lang")
    private String lang;

    @XStreamAlias("respcode")
    private String respCode;

    @XStreamAlias("respmsg")
    private String respMsg;

    @XStreamAlias("respdesc")
    private String respDesc;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("transactionNo", transactionNo)
                .append("lang", lang)
                .append("respCode", respCode)
                .append("respMsg", respMsg)
                .append("respDesc", respDesc)
                .toString();
    }
}
