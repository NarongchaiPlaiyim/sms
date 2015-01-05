package com.beci.service.xml.truemove.reply;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("destination")
public class Destination {

    @XStreamAlias("messageid")
    @XStreamAsAttribute
    private String messageId;

    @XStreamAlias("address")
    private Address address;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("messageId", messageId)
                .append("address", address)
                .toString();
    }
}
