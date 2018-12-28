package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "roles")
public class Roles extends Base{
    @Column
    private String name;
    @Column(name = "is_deletable")
    private boolean isDeletable;
}
