package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "resources")
public class Resources extends Base{
    @Column
    private String name;
    @Column
    private String code;
}
