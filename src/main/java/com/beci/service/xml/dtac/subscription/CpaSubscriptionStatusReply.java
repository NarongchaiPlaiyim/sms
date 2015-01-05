package com.beci.service.xml.dtac.subscription;

import com.beci.service.xml.dtac.subscription.reply.Destination;
import com.beci.service.xml.dtac.subscription.reply.SubscriptionStatus;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@XStreamAlias("cpa-subscription-status-reply")
public class CpaSubscriptionStatusReply {
    @XStreamAlias("txid")
    private String txId;

    @XStreamAlias("destination")
    private Destination destination;

    @XStreamImplicit(itemFieldName="subscription-status")
    private List<SubscriptionStatus> subscriptionStatusList;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("txId", txId)
                .append("destination", destination)
                .append("subscriptionStatusList", subscriptionStatusList)
                .toString();
    }
}
