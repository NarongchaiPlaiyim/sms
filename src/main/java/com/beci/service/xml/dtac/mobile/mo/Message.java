package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("message")
public class Message {
    @XStreamAlias("header")
    private Header header;

    @XStreamAlias("sms")
    private Sms sms;

    @XStreamAlias("mms")
    private Mms mms;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("header", header)
                .append("sms", sms)
                .append("mms", mms)
                .toString();
    }
}
