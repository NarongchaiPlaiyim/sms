package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("ivr")
public class Ivr {
    @XStreamAlias("from")
    private String from;

    @XStreamAlias("content-id")
    private String contentId;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("from", from)
                .append("contentId", contentId)
                .toString();
    }
}
