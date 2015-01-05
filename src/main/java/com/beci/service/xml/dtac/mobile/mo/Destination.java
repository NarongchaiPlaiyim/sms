package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("destination")
public class Destination {
    @XStreamAlias("msisdn")
    private String msisdn;

    @XStreamAlias("serviceid")
    private String serviceId;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("msisdn", msisdn)
                .append("serviceId", serviceId)
                .toString();
    }
}
