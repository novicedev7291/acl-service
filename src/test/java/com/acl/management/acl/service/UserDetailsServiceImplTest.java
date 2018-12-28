package com.acl.management.acl.service;

import com.acl.management.acl.model.Users;
import com.acl.management.acl.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;

@RunWith(SpringRunner.class)
public class UserDetailsServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private HttpServletRequest request;
    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Test
    public void shouldLoadUserByUsername(){
        String companyId = "DEF";
        String username = "admin";
        Users user = createUser(companyId);
        Mockito.when(request.getParameter(Mockito.anyString())).thenReturn(companyId);
        Mockito.when(userRepository.findByCompanyIdAndUsernameAndActive(companyId, username, true))
                .thenReturn(user);
        UserDetails userDetail = userDetailsService.loadUserByUsername(username);
        Assert.assertNotNull(userDetail);
    }

    private Users createUser(String companyId){
        Users user = new Users();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("admin");
        user.setActive(true);
        user.setCompanyId(companyId);
        return user;
    }
}
