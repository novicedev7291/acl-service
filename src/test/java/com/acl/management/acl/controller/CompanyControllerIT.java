package com.acl.management.acl.controller;

import com.acl.management.acl.AclServiceApplication;
import com.acl.management.acl.data.TestDataMaker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AclServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class CompanyControllerIT {
    private final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mvc;

    @Test
    public void should_create_new_company() throws Exception{
        this.mvc
                .perform(post(TestDataMaker.COMPANIES_ENDPOINT)
                        .header(TestDataMaker.AUTHORIZATION, "Bearer "+obtainAccessToken("admin", "P@ssw111rd"))
                        .header(TestDataMaker.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .header(TestDataMaker.X_COMPANY, TestDataMaker.COMPANY_ID)
                        .content(mapper.writeValueAsBytes(TestDataMaker.createCompanyData())))
                .andExpect(status().isCreated());

    }

    @Test
    public void should_fail_with_403_error() throws Exception{
        this.mvc
                .perform(post(TestDataMaker.COMPANIES_ENDPOINT)
                        .header(TestDataMaker.AUTHORIZATION, "Bearer "+obtainAccessToken("test_admin", "P@ssw111rd"))
                        .header(TestDataMaker.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .header(TestDataMaker.X_COMPANY, TestDataMaker.COMPANY_ID)
                        .content(mapper.writeValueAsBytes(TestDataMaker.createCompanyData())))
                .andExpect(status().isForbidden());
    }

    private String obtainAccessToken(String username, String password) throws Exception{
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("username", username);
        params.add("password", password);
        params.add("companyId", "DEF");

        ResultActions result
                = mvc.perform(post("/oauth/token")
                .params(params)
                .with(httpBasic("default_client","P@ssw111rd"))
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        String resultString = result.andReturn().getResponse().getContentAsString();
        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }
}
