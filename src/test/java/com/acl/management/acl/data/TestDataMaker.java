package com.acl.management.acl.data;

import com.acl.management.acl.model.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestDataMaker {
    public static final String AUTHORIZATION = "Authorization";
    public static final String X_COMPANY = "X-COMPANY";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String COMPANY_ID = "DEF";
    public static final String COMPANIES_ENDPOINT = "/companies";
    private static final String companyName = "Test Company";
    private static final String companyPrefix = "TEST";

    public static UserDetails userObject(){
        return new User("admin", "admin@password", true
                        , true, true, true, Collections.emptyList());
    }

    public static Users usersObject(){
        Users user = new Users();
        user.setId(1);
        user.setEmail("test.admin@test.com");
        user.setPhone("8800337922");
        user.setCountryCode("+91");
        user.setPassword("$2a$12$gvdFggwjBlIfGBdhAFV4GuuV7yLX885poCISv5ngd6HueURERkkqy");
        user.setActive(true);
        user.setName("Test user");
        user.setRoles(rolesList());
        return user;
    }

    public static Set<Roles> rolesList(){
        Roles role = new Roles();
        role.setId(1);
        role.setName("Admin");
        role.setCompanyId("COMPANY_ID");
        role.setPermissions(permisionsList());
        Set<Roles> roles = new HashSet<>();
        roles.add(role);
        return roles;
    }

    public static Set<Permissions> permisionsList(){
        Permissions permission = new Permissions();
        permission.setRoleId(1);
        permission.setName("CREATE_COMPANY");
        permission.setId(1);
        permission.setResourceId(1);
        permission.setOperationId(1);
        permission.setVerb("POST");
        permission.setCompanyId("COMPANY_ID");
        permission.setLink("/companies");
        Set<Permissions> permissions = new HashSet<>();
        permissions.add(permission);
        return permissions;
    }

    public static Company createCompanyData(){
        return new Company("TEST", "Test Company", "test.company@abc.com","Test address Test city", "8800337922", "+91", "admin_test", "P@ssw11rd");
    }

    public static Companies companyModelObject(){
        Companies company = new Companies();
        company.setId(1);
        company.setName(companyName);
        company.setDescription(companyName);
        company.setActive(true);
        company.setCode(companyPrefix);
        return company;
    }
}
