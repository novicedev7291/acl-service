package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "permissions")
public class Permissions extends Base {
    @Column
    String name;
    @Column(name = "resource_id")
    Integer resourceId;
    @Column(name = "is_deletable")
    boolean isDeletable;
    @Column(name = "operation_id")
    Integer operationId;
    @Column
    String verb;
    @Column
    String link;
    @Column(name = "role_id")
    Integer roleId;
}
