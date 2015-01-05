package com.beci.service.xml.dtac.dr.reply;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Setter
@Getter
@XStreamAlias("authentication")
public class Authentication {
    @XStreamAlias("user")
    private String user;

    @XStreamAlias("password")
    private String password;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("user", user)
                .append("password", password)
                .toString();
    }
}
