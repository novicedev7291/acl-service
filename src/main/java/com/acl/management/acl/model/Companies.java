package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "companies")
public class Companies extends AbstractBase{
    @Column
    String name;
    @Column
    String code;
    @Column
    String description;
    @Column
    boolean active;
    @Column(name = "customize_info")
    String customizeInfo;
    @Column(name = "security_info")
    String securityInfo;
}
