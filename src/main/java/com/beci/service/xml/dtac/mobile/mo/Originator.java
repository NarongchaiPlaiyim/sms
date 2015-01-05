package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("originator")
public class Originator {
    @XStreamAlias("msisdn")
    private String msisdn;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("msisdn", msisdn)
                .toString();
    }
}
