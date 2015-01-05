package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("body")
public class BodySmil {
    @XStreamAlias("par")
    private Par par;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("par", par)
                .toString();
    }
}
