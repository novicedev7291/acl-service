package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Roles{
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
    private String name;
    @Column(name = "is_deletable")
    private boolean isDeletable;
    @Column(name = "company_id")
    String companyId;
}
