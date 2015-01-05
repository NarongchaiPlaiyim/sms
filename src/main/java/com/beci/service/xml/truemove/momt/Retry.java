package com.beci.service.xml.truemove.momt;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("retry")
public class Retry {
    @XStreamAlias("count")
    @XStreamAsAttribute
    private String count;

    @XStreamAlias("max")
    @XStreamAsAttribute
    private String max;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("count", count)
                .append("max", max)
                .toString();
    }
}
