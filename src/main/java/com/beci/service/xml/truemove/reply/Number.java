package com.beci.service.xml.truemove.reply;

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
@XStreamAlias("number")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"content"})
public class Number {
    @XStreamAlias("type")
    @XStreamAsAttribute
    private String type;

    private String content;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("content", content)
                .toString();
    }
}
