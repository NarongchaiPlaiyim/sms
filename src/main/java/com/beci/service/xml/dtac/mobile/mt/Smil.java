package com.beci.service.xml.dtac.mobile.mt;

import com.beci.service.xml.dtac.mobile.mo.BodySmil;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("smil")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"content"})
public class Smil {
    private String content;

    @XStreamAlias("head")
    private HeadSmil headSmil;

    @XStreamAlias("body")
    private BodySmil bodySmil;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("content", content)
                .append("headSmil", headSmil)
                .append("bodySmil", bodySmil)
                .toString();
    }
}
