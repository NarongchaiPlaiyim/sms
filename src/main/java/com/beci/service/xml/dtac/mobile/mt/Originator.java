package com.beci.service.xml.dtac.mobile.mt;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("originator")
public class Originator {
    @XStreamAlias("sender")
    private String sender;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("sender", sender)
                .toString();
    }
}
