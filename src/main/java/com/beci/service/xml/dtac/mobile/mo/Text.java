package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("text")
public class Text {
    @XStreamAlias("src")
    @XStreamAsAttribute
    private String src;

    @XStreamAlias("region")
    @XStreamAsAttribute
    private String region;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("src", src)
                .append("region", region)
                .toString();
    }
}
