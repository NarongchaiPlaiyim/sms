package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("header")
public class Header {
    @XStreamAlias("valid-period")
    private String validPeriod;

    @XStreamAlias("timestamp")
    private String timeStamp;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("validPeriod", validPeriod)
                .append("timeStamp", timeStamp)
                .toString();
    }
}
