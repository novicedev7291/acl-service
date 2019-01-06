package com.acl.management.acl.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MethodSecurityConfigTest {
    @Mock
    private ApplicationContext context;
    @InjectMocks
    private MethodSecurityConfig config;

    @Test
    public void shouldCreateExpressionHandler(){
        config.createExpressionHandler();
    }
}
