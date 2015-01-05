package com.beci.service.xml.truemove.momt;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("sms")
public class Sms {
    @XStreamAlias("type")
    @XStreamAsAttribute
    private String type;

    @XStreamAlias("service-id")
    private String serviceId;

    @XStreamAlias("destination")
    private Destination destination;

    @XStreamAlias("source")
    private Source source;

    @XStreamAlias("ud")
    private Ud ud;

    @XStreamAlias("scts")
    private String scts;

    @XStreamAlias("dro")
    private String dro;

    @XStreamAlias("retry")
    private Retry retry;

    @XStreamAlias("ussd_session")
    private UssdSession ussdSession;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("serviceId", serviceId)
                .append("destination", destination)
                .append("source", source)
                .append("ud", ud)
                .append("scts", scts)
                .append("dro", dro)
                .append("retry", retry)
                .append("ussdSession", ussdSession)
                .toString();
    }
}
