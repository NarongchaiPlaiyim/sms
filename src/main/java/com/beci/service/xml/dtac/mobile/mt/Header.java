package com.beci.service.xml.dtac.mobile.mt;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("header")
public class Header {
    @XStreamAlias("timestamp")
    private String timeStamp;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("timeStamp", timeStamp)
                .toString();
    }
}
