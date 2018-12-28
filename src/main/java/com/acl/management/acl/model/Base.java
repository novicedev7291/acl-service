package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class Base extends AbstractBase{
    @Column(name = "company_id")
    private String companyId;
}
