package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "permissions")
public class Permissions{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(roleId)
                .append(name)
                .append(verb)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  Permissions)){
            return false;
        }
        Permissions that = (Permissions) obj;
        if(this == that) return true;
        if(this.id.equals(that.id) && this.name.equals(that.name)
                && this.resourceId.equals(that.resourceId)
                && this.roleId.equals(that.roleId)
                && this.verb.equals(that.verb)
                && this.link.equals(that.link)
                && this.operationId.equals(that.operationId))
            return true;
        return false;
    }
}
