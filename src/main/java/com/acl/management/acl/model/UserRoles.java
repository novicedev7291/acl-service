package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "user_roles")
public class UserRoles extends AbstractBase {
    @Column(name = "role_id")
    Integer roleId;
    @Column(name = "user_id")
    Integer userId;
}
