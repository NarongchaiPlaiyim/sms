package com.beci.service.xml.dtac.mobile;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("cpa-response")
public class CpaResponse {
    @XStreamAlias("txid")
    private String txId;

    @XStreamAlias("status")
    private String status;

    @XStreamAlias("status-description")
    private String statusDescription;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("txId", txId)
                .append("status", status)
                .append("statusDescription", statusDescription)
                .toString();
    }
}
