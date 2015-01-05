package com.beci.service.xml.dtac.mobile.mt;

import com.beci.service.xml.dtac.mobile.mo.Layout;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("head")
public class HeadSmil {
    @XStreamAlias("layout")
    private Layout layout;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("layout", layout)
                .toString();
    }
}
