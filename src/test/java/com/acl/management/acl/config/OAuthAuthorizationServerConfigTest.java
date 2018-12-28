package com.acl.management.acl.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
public class OAuthAuthorizationServerConfigTest {
    @Mock
    private DataSource dataSource;
    @InjectMocks
    private OAuth2AuthorizationServerConfig oauthConfig;

    @Test
    public void shouldConfigureClientsDetailsServiceConfigurer() throws Exception {
        ClientDetailsServiceBuilder<?> builder = new ClientDetailsServiceBuilder<>();
        ClientDetailsServiceConfigurer clients = new ClientDetailsServiceConfigurer(builder);
        oauthConfig.configure(clients);
    }

    @Test
    public void shouldAuthorizationServerSecurityConfigurer() throws Exception {
        AuthorizationServerSecurityConfigurer configurer = new AuthorizationServerSecurityConfigurer();
        oauthConfig.configure(configurer);
    }

    @Test
    public void shouldAuthorizationServerEndpointsConfigurer() throws Exception{
        AuthorizationServerEndpointsConfigurer configurer = new AuthorizationServerEndpointsConfigurer();
        oauthConfig.configure(configurer);
    }

}
