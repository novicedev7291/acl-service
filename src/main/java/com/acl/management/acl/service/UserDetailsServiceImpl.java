package com.acl.management.acl.service;

import com.acl.management.acl.model.Users;
import com.acl.management.acl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

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
                true, true, Collections.EMPTY_LIST);
    }

    private String getCompanyId(HttpServletRequest request){
        String companyId = request.getParameter("companyId");
        return companyId;
    }
}
