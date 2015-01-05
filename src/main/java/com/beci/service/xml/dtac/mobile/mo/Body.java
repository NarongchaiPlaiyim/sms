package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@XStreamAlias("body")
public class Body {
    @XStreamImplicit(itemFieldName="content")
    private List<Content> contentList;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("contentList", contentList)
                .toString();
    }
}
