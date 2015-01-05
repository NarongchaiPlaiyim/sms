package com.beci.service.xml.dtac.dr;

import com.beci.service.xml.dtac.dr.reply.Authentication;
import com.beci.service.xml.dtac.dr.reply.Destination;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@XStreamAlias("cpa-dr-reply")
public class CpaDrReply {
    @XStreamAlias("txid")
    private String txId;

    @XStreamAlias("authentication")
    private Authentication authentication;

    @XStreamAlias("destination")
    private Destination destination;

    @XStreamAlias("call-date")
    private String callDate;

    public CpaDrReply() {

    }

    public CpaDrReply(String txId, Authentication authentication, Destination destination, String callDate) {
        this.txId = txId;
        this.authentication = authentication;
        this.destination = destination;
        this.callDate = callDate;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getCallDate() {
        return callDate;
    }

    public void setCallDate(String callDate) {
        this.callDate = callDate;
    }
}
