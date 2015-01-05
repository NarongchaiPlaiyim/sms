package com.beci.service.xml.dtac.subscription.reply;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("subscription-status")
public class SubscriptionStatus {
    @XStreamAlias("msisdn")
    private String msisdn;

    @XStreamAlias("status")
    private String status;

    @XStreamAlias("status-code")
    private String statusCode;

    @XStreamAlias("status-description")
    private String statusDescription;

    @XStreamAlias("start-date")
    private String startDate;

    @XStreamAlias("expired-date")
    private String expiredDate;

    @XStreamAlias("latest-billed-date")
    private String latestBilledDate;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("msisdn", msisdn)
                .append("status", status)
                .append("statusCode", statusCode)
                .append("statusDescription", statusDescription)
                .append("startDate", startDate)
                .append("expiredDate", expiredDate)
                .append("latestBilledDate", latestBilledDate)
                .toString();
    }
}
