package com.company.samplechecklist.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.Lob;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

@NamePattern("%s|name")
@Table(name = "SAMPLECHECKLIST_CHECK")
@Entity(name = "samplechecklist$Check")
public class Check extends StandardEntity {
    private static final long serialVersionUID = 4027870480098772428L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GROUP_ID")
    protected ChecksGroup group;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OPTIONS_GROUP_ID")
    protected OptionsGroup optionsGroup;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGroup(ChecksGroup group) {
        this.group = group;
    }

    public ChecksGroup getGroup() {
        return group;
    }

    public void setOptionsGroup(OptionsGroup optionsGroup) {
        this.optionsGroup = optionsGroup;
    }

    public OptionsGroup getOptionsGroup() {
        return optionsGroup;
    }


}