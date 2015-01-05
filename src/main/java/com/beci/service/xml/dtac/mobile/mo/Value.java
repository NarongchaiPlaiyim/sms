package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("value")
public class Value {
    @XStreamAlias("string")
    private String string;

    @XStreamAlias("smil")
    private Smil smil;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("string", string)
                .append("smil", smil)
                .toString();
    }
}
