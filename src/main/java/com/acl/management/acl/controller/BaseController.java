package com.acl.management.acl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract class BaseController {
    @Autowired
    private HttpServletRequest request;

    public String getCompanyId() throws RuntimeException{
        String companyId = request.getHeader("X-COMPANY");
        Assert.notNull(companyId, "Company Id header not found");
        return companyId;
    }
}
