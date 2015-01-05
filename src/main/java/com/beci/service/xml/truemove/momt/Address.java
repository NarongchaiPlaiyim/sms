package com.beci.service.xml.truemove.momt;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.lang.*;

@Setter
@Getter
@XStreamAlias("address")
public class Address {
    @XStreamAlias("number")//
    private Number number;

    @XStreamAlias("originate")
    private Originate originate;

    @XStreamAlias("sender")
    private String sender;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("number", number)
                .append("originate", originate)
                .append("sender", sender)
                .toString();
    }
}
