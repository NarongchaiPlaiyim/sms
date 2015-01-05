package com.beci.service.xml.truemove.reply;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("rsr")
public class Rsr {
    @XStreamAlias("type")
    @XStreamAsAttribute
    private String type;

    @XStreamAlias("service-id")
    private String serviceId;

    @XStreamAlias("destination")
    private Destination destination;

    @XStreamAlias("source")
    private Source source;

    @XStreamAlias("rsr_detail")
    private RsrDetail rsrDetail;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("serviceId", serviceId)
                .append("destination", destination)
                .append("source", source)
                .append("rsrDetail", rsrDetail)
                .toString();
    }
}
