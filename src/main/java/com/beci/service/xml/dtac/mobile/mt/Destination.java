package com.beci.service.xml.dtac.mobile.mt;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@XStreamAlias("destination")
public class Destination {
    @XStreamAlias("serviceid")
    private String serviceId;

    @XStreamImplicit(itemFieldName="msisdn")
    private List<String> msisdn;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("serviceId", serviceId)
                .append("msisdn", msisdn)
                .toString();
    }
}
