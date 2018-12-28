package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "user_roles")
public class UserRoles{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer id;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_on")
    private Instant createdOn;
    @Column(name = "updated_by")
    private String udpatedBy;
    @Column(name = "updated_on")
    private Instant updatedOn;
    @Column(name = "role_id")
    Integer roleId;
    @Column(name = "user_id")
    Integer userId;
}
