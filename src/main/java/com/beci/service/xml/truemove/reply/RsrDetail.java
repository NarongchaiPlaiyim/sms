package com.beci.service.xml.truemove.reply;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("rsr_detail")
public class RsrDetail {
    @XStreamAlias("status")
    @XStreamAsAttribute
    private String status;

    @XStreamAlias("code")
    private String code;

    @XStreamAlias("description")
    private String description;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("status", status)
                .append("code", code)
                .append("description", description)
                .toString();
    }
}
