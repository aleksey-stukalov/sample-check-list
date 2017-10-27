package com.company.samplechecklist.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

@NamePattern("%s|value")
@Table(name = "SAMPLECHECKLIST_OPTION")
@Entity(name = "samplechecklist$Option")
public class Option extends StandardEntity {
    private static final long serialVersionUID = 6014560379656379131L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GROUP_ID")
    protected OptionsGroup group;

    @Column(name = "VALUE_", nullable = false)
    protected String value;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    public void setGroup(OptionsGroup group) {
        this.group = group;
    }

    public OptionsGroup getGroup() {
        return group;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}