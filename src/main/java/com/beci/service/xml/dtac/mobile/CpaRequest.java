package com.beci.service.xml.dtac.mobile;

import com.beci.service.xml.dtac.mobile.mt.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("cpa-request")
public class CpaRequest {
    @XStreamAlias("txid")
    private String txId;

    @XStreamAlias("authentication")
    private Authentication authentication;

    @XStreamAlias("originator")
    private Originator originator;

    @XStreamAlias("destination")
    private Destination destination;

    @XStreamAlias("message")
    private Message message;

    @XStreamAlias("help-message")
    private HelpMessage helpMessage;

    @XStreamAlias("second-message")
    private SecondMessage secondMessage;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("txId", txId)
                .append("authentication", authentication)
                .append("originator", originator)
                .append("destination", destination)
                .append("message", message)
                .append("helpMessage", helpMessage)
                .append("secondMessage", secondMessage)
                .toString();
    }
}

