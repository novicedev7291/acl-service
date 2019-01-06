package com.acl.management.acl.handler;

import com.acl.management.acl.repository.UserRepository;
import com.acl.management.acl.service.UserDetailsServiceImpl;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

public class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {
    private AuthenticationTrustResolverImpl trustResolver = new AuthenticationTrustResolverImpl();
    private ApplicationContext appContext;

    public CustomMethodSecurityExpressionHandler(ApplicationContext appContext) {
        this.appContext = appContext;
    }

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
        CustomMethodSecurityExpressionRoot expressionRoot = new CustomMethodSecurityExpressionRoot(authentication);
        expressionRoot.setTrustResolver(trustResolver);
        expressionRoot.setPermissionEvaluator(getPermissionEvaluator());
        expressionRoot.setRoleHierarchy(getRoleHierarchy());
        expressionRoot.setThis(invocation.getThis());
        expressionRoot.setUserRepository((UserRepository) appContext.getBean(UserRepository.class));
        return expressionRoot;
    }
}
