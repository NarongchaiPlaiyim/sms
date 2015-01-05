package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("ussd")
public class Ussd {
    @XStreamAlias("content-id")
    private String contentId;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("contentId", contentId)
                .toString();
    }
}
