package com.beci.service.xml.dtac.subscription;

import com.beci.service.xml.dtac.subscription.request.Destination;
import com.beci.service.xml.dtac.subscription.request.Authentication;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("cpa-subscription-status-query")
public class CpaSubscriptionStatusQuery {
    @XStreamAlias("txid")
    private String txId;

    @XStreamAlias("authentication")
    private Authentication authentication;

    @XStreamAlias("destination")
    private Destination destination;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("txId", txId)
                .append("authentication", authentication)
                .append("destination", destination)
                .toString();
    }
}
