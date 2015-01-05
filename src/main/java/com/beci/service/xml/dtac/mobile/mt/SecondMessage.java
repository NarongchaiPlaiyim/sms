package com.beci.service.xml.dtac.mobile.mt;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("second-message")
public class SecondMessage {
    @XStreamAlias("message")
    private Message message;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("message", message)
                .toString();
    }
}
