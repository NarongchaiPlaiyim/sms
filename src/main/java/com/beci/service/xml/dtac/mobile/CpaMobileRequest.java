package com.beci.service.xml.dtac.mobile;

import com.beci.service.xml.dtac.mobile.mo.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("cpa-mobile-request")
public class CpaMobileRequest {
    @XStreamAlias("txid")
    private String txId;

    @XStreamAlias("authentication")
    private Authentication authentication;

    @XStreamAlias("destination")
    private Destination destination;

    @XStreamAlias("originator")
    private Originator originator;

    @XStreamAlias("ivr")
    private Ivr ivr;

    @XStreamAlias("ussd")
    private Ussd ussd;

    @XStreamAlias("message")
    private Message message;

    @XStreamAlias("startCallDateTime")
    private String startCallDateTime;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("txId", txId)
                .append("authentication", authentication)
                .append("destination", destination)
                .append("originator", originator)
                .append("ivr", ivr)
                .append("ussd", ussd)
                .append("message", message)
                .append("startCallDateTime", startCallDateTime)
                .toString();
    }
}
