package com.beci.service.xml.dtac.mobile.mt;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("mms")
public class Mms {
    @XStreamAlias("from")
    private String from;

    @XStreamAlias("subject")
    private String subject;

    @XStreamAlias("body")
    private Body body;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("from", from)
                .append("subject", subject)
                .append("body", body)
                .toString();
    }
}
