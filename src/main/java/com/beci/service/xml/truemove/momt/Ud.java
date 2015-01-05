package com.beci.service.xml.truemove.momt;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("ud")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"content"})
public class Ud {
    @XStreamAlias("type")
    @XStreamAsAttribute
    private String type;

    @XStreamAlias("encoding")
    @XStreamAsAttribute
    private String encoding;

    private String content;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("encoding", encoding)
                .append("content", content)
                .toString();
    }
}
