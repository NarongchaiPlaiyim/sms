package com.beci.service.xml.dtac.mobile.mt;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("content")
public class Content {
    @XStreamAlias("content-id")
    private String contentId;

    @XStreamAlias("content-type")
    private String contentType;

    @XStreamAlias("value")
    private Value value;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("contentId", contentId)
                .append("contentType", contentType)
                .append("value", value)
                .toString();
    }
}
