package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("smil")
public class Smil {
    @XStreamAlias("head")
    private HeadSmil headSmil;

    @XStreamAlias("body")
    private BodySmil bodySmil;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("headSmil", headSmil)
                .append("bodySmil", bodySmil)
                .toString();
    }
}
