package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("root-layout")
public class RootLayout {
    @XStreamAlias("width")
    @XStreamAsAttribute
    private String width;

    @XStreamAlias("height")
    @XStreamAsAttribute
    private String height;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("width", width)
                .append("height", height)
                .toString();
    }
}
