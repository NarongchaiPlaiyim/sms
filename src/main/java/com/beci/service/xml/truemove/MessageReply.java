package com.beci.service.xml.truemove;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.beci.service.xml.truemove.reply.Rsr;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("message")
public class MessageReply {
    @XStreamAlias("id")
    @XStreamAsAttribute
    private String id;

    @XStreamAlias("rsr")
    private Rsr rsr;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("rsr", rsr)
                .toString();
    }
}
