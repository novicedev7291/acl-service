package com.acl.management.acl.controller;

import com.acl.management.acl.data.TestDataMaker;
import com.acl.management.acl.model.Companies;
import com.acl.management.acl.model.Company;
import com.acl.management.acl.service.CompanyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest(value = CompanyController.class, secure = false)
public class CompanyControllerTest {
    @MockBean
    private CompanyService companyService;
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void shouldCreateCompany() throws Exception{
        Company info = TestDataMaker.createCompanyData();
        Companies company = TestDataMaker.companyModelObject();
        when(companyService.createCompany(any(Company.class))).thenReturn(company);
        mvc.perform(MockMvcRequestBuilders.post(TestDataMaker.COMPANIES_ENDPOINT).content(mapper.writeValueAsBytes(info))
                    .header(TestDataMaker.AUTHORIZATION, "Bearer 25ec4ade-fa5e-4d1f-9f0a-d24d858f989b")
                    .header(TestDataMaker.X_COMPANY, TestDataMaker.COMPANY_ID)
                    .header(TestDataMaker.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.equalTo(company.getId())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.equalTo(company.getName())));

        Mockito.verify(companyService, times(1)).createCompany(any(Company.class));
        verifyNoMoreInteractions(companyService);
    }
}
