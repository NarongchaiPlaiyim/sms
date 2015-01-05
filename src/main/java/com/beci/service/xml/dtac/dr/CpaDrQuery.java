package com.beci.service.xml.dtac.dr;

import com.beci.service.xml.dtac.dr.query.Authentication;
import com.beci.service.xml.dtac.dr.query.Destination;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("cpa-dr-query")
public class CpaDrQuery {
    @XStreamAlias("txid")
    private String txId;

    @XStreamAlias("authentication")
    private Authentication authentication;

    @XStreamAlias("destination")
    private Destination destination;

    @XStreamAlias("call-date")
    private String callDate;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("txId", txId)
                .append("authentication", authentication)
                .append("destination", destination)
                .append("callDate", callDate)
                .toString();
    }
}

