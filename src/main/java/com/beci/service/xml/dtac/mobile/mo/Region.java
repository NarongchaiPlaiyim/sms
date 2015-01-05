package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("region")
public class Region {
    @XStreamAlias("id")
    @XStreamAsAttribute
    private String id;

    @XStreamAlias("top")
    @XStreamAsAttribute
    private String top;

    @XStreamAlias("left")
    @XStreamAsAttribute
    private String left;

    @XStreamAlias("height")
    @XStreamAsAttribute
    private String height;

    @XStreamAlias("width")
    @XStreamAsAttribute
    private String width;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("top", top)
                .append("left", left)
                .append("height", height)
                .append("width", width)
                .toString();
    }
}
