package com.acl.management.acl.service;

import com.acl.management.acl.data.TestDataMaker;
import com.acl.management.acl.model.Companies;
import com.acl.management.acl.repository.CompanyRepository;
import com.acl.management.acl.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CompanyServiceImplTest {
    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private CompanyServiceImpl companyService;

    @Test
    public void shouldCreateCompany(){
        Companies company = companyService.createCompany(TestDataMaker.createCompanyData());
        Assert.assertNotNull(company);
    }
}
