package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "users")
public class Users extends Base{
    @Column
    private String name;
    @Column(name = "user_name")
    private String username;
    @Column
    private String password;
    @Column(name = "country_code")
    private String countryCode;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private Boolean active;
    @Column(name = "change_password")
    private boolean changePassword;
}
