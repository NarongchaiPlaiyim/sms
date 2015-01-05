package com.beci.service.xml.truemove.reply;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("number")//
public class Address {
    @XStreamAlias("number")//
    private Number number;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("number", number)
                .toString();
    }
}
