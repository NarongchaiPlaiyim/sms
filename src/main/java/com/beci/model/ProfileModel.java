package com.beci.model;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@Setter
@Getter
@Entity
@Table(name = "profile", schema = "", catalog = "hibernatetest")
@XmlRootElement
public class ProfileModel {
    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    @XmlAttribute
    private int id;

    @Basic
    @Column(name = "FIRST_NAME", nullable = true, insertable = true, updatable = true, length = 50)
    @XmlAttribute
    private String firstName;

    @Basic
    @Column(name = "LAST_NAME", nullable = true, insertable = true, updatable = true, length = 50)
    @XmlAttribute
    private String lastName;

    public ProfileModel() {

    }

    public ProfileModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .toString();
    }
}
