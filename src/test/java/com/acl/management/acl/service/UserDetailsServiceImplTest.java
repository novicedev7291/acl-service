package com.acl.management.acl.service;

import com.acl.management.acl.model.Permissions;
import com.acl.management.acl.model.Roles;
import com.acl.management.acl.model.Users;
import com.acl.management.acl.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RunWith(SpringRunner.class)
public class UserDetailsServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private HttpServletRequest request;
    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;
    private String companyId = "COMPANY_ID";
    private String username = "admin";

    @Test
    public void shouldLoadUserByUsername(){
        Users user = createUser(companyId);
        Mockito.when(request.getParameter(Mockito.anyString())).thenReturn(companyId);
        Mockito.when(userRepository.findByCompanyIdAndUsernameAndActive(companyId, username, true))
                .thenReturn(user);
        UserDetails userDetail = userDetailsService.loadUserByUsername(username);
        Assert.assertNotNull(userDetail);
    }

    @Test
    public void shouldReturnUserWithGrantedAuthorities(){
        Users user = createUser(companyId);
        Mockito.when(request.getParameter(Mockito.anyString())).thenReturn(companyId);
        Mockito.when(userRepository.findByCompanyIdAndUsernameAndActive(companyId, username, true))
                .thenReturn(user);
        UserDetails userDetail = userDetailsService.loadUserByUsername(username);
        Assert.assertTrue(userDetail.getAuthorities().size() > 0);
    }

    private Users createUser(String companyId){
        Users user = new Users();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("admin");
        user.setActive(true);
        user.setCompanyId(companyId);
        user.setRoles(userRoles());
        return user;
    }

    private Set<Roles> userRoles(){
        Roles role = new Roles();
        role.setName("Admin");
        role.setId(1);
        role.setPermissions(permissions());
        Set<Roles> roles = new HashSet<>();
        roles.add(role);
        return roles;
    }

    private Set<Permissions> permissions(){
        Permissions permission = new Permissions();
        permission.setId(1);
        permission.setName("CREATE_COMPANY");
        permission.setRoleId(1);
        Set<Permissions> permissions = new HashSet<>();
        permissions.add(permission);
        return permissions;
    }
}
