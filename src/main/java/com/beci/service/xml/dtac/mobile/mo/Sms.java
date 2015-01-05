package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("message")
public class Sms {
    @XStreamAlias("msg")
    private String msg;

    @XStreamAlias("msgtype")
    private String msgType;

    @XStreamAlias("encoding")
    private String encoding;

    @XStreamAlias("userheader")
    private String userHeader;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("msg", msg)
                .append("msgType", msgType)
                .append("encoding", encoding)
                .append("userHeader", userHeader)
                .toString();
    }
}
