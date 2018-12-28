package com.acl.management.acl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "oauth_client_details")
public class OAuthClientDetails{
    @Column(name = "client_id")
    String clientId;
    @Column(name = "client_secret")
    String clientSecret;
    @Column(name = "resourceIds")
    String resourceIds;
    @Column(name = "scope")
    String scope;
    @Column(name = "authorized_grant_types")
    String grantTypes;
    @Column(name = "web_server_redirect_uri")
    String redirectUri;
    @Column(name = "authorities")
    String authorities;
    @Column(name = "access_token_validity")
    Integer accessTokenValidity;
    @Column(name = "refresh_token_validity")
    Integer refreshTokenValidity;
    @Column(name = "additional_information")
    String additionalInformation;
    @Column(name = "autoapprove")
    String autoApprove;
}
