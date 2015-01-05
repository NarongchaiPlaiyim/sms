package com.beci.service.xml.truemove.reply;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("source")
public class Source {
    @XStreamAlias("address")
    private Address address;

    @XStreamAlias("sender")
    private String sender;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("address", address)
                .append("sender", sender)
                .toString();
    }
}
