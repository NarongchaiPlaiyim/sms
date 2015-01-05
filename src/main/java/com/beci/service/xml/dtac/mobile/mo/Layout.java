package com.beci.service.xml.dtac.mobile.mo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("layout")
public class Layout {
    @XStreamAlias("root-layout")
    private RootLayout rootLayout;

    @XStreamAlias("region")
    private Region region;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("rootLayout", rootLayout)
                .append("region", region)
                .toString();
    }
}
