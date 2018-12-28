package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "companies")
public class Companies{
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
