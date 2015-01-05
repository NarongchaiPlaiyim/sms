package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("par")
public class Par {
    @XStreamAlias("dur")
    @XStreamAsAttribute
    private String dur;

    @XStreamAlias("text")
    private Text text;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("dur", dur)
                .append("text", text)
                .toString();
    }
}
