package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "permissions")
public class Permissions{
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
    @Column
    String name;
    @Column(name = "resource_id")
    Integer resourceId;
    @Column(name = "is_deletable")
    boolean isDeletable;
    @Column(name = "operation_id")
    Integer operationId;
    @Column(name = "company_id")
    String companyId;
    @Column
    String verb;
    @Column
    String link;
    @Column(name = "role_id")
    Integer roleId;
}
