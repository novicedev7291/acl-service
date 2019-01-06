package com.acl.management.acl.controller;

import com.acl.management.acl.model.Companies;
import com.acl.management.acl.model.Company;
import com.acl.management.acl.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController extends BaseController{
    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    @PreAuthorize("isAuthorized('POST','/companies')")
    public ResponseEntity<Companies> create(@RequestBody Company info){
        return new ResponseEntity<Companies>(companyService.createCompany(info), HttpStatus.CREATED);
    }
}
