package com.beci.service.xml.truemove;

import com.beci.service.xml.truemove.momt.Sms;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("message")
public class MessageMOMT {
    @XStreamAlias("id")
    @XStreamAsAttribute
    private String id;

    @XStreamAlias("sms")
    private Sms sms;

    @XStreamAlias("from")
    private String from;

    @XStreamAlias("to")
    private String to;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("sms", sms)
                .append("from", from)
                .append("to", to)
                .toString();
    }
}
