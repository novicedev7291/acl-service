package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {
    String prefix;
    String name;
    String email;
    String address;
    String phone;
    String countryCode;
    String username;
    String password;

    public Company() {
    }

    public Company(String prefix, String name, String email, String address, String phone, String countryCode, String username, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.countryCode = countryCode;
        this.username = username;
        this.password = password;
        this.prefix = prefix;
    }
}
