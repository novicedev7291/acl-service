package com.acl.management.acl.service;

import com.acl.management.acl.model.Permissions;
import com.acl.management.acl.model.Roles;
import com.acl.management.acl.model.Users;
import com.acl.management.acl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    private UserRepository userRepository;
    private HttpServletRequest request;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, HttpServletRequest request){
        this.userRepository = userRepository;
        this.request = request;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByCompanyIdAndUsernameAndActive(getCompanyId(request), username, true);
        return new User(user.getUsername(), user.getPassword(), user.getActive(), true,
                true, true, getGrantedAuthorities(user));
    }

    private final Collection<? extends GrantedAuthority> getGrantedAuthorities(final Users user){
        Set<Roles> roles = user.getRoles();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<Permissions> permissions = new ArrayList<>();
        for(Roles role : roles){
            permissions.addAll(role.getPermissions());
        }

        for(Permissions permission: permissions){
            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
        }

        return grantedAuthorities;
    }

    private String getCompanyId(HttpServletRequest request){
        String companyId = request.getParameter("companyId");
        return companyId;
    }
}
