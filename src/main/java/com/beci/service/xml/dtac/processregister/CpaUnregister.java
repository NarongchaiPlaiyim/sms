package com.beci.service.xml.dtac.processregister;

import com.beci.service.xml.dtac.processregister.unregister.Authentication;
import com.beci.service.xml.dtac.processregister.unregister.Destination;
import com.beci.service.xml.dtac.processregister.unregister.Originator;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("cpa-unregister")
public class CpaUnregister {
    @XStreamAlias("txid")
    private String txId;

    @XStreamAlias("org-type")
    private String orgType;

    @XStreamAlias("authentication")
    private Authentication authentication;

    @XStreamAlias("originator")
    private Originator originator;

    @XStreamAlias("destination")
    private Destination destination;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("txId", txId)
                .append("orgType", orgType)
                .append("authentication", authentication)
                .append("originator", originator)
                .append("destination", destination)
                .toString();
    }
}
