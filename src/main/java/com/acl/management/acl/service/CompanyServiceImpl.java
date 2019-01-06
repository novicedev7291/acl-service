package com.acl.management.acl.service;

import com.acl.management.acl.model.Companies;
import com.acl.management.acl.model.Company;
import com.acl.management.acl.model.Users;
import com.acl.management.acl.repository.CompanyRepository;
import com.acl.management.acl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService{
    private CompanyRepository companyRepository;
    private UserRepository userRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public Companies createCompany(Company companyInfo) {
        Companies company = new Companies();
        company.setCode(companyInfo.getPrefix());
        company.setName(companyInfo.getName());
        company.setActive(true);
        company.setDescription(companyInfo.getName());
        companyRepository.save(company);

        Users user = new Users();
        user.setName(companyInfo.getName());
        user.setCompanyId(companyInfo.getPrefix());
        user.setActive(true);
        user.setUsername(companyInfo.getUsername());
        user.setPassword(new BCryptPasswordEncoder(12).encode(companyInfo.getPassword()));
        user.setCountryCode(companyInfo.getCountryCode());
        user.setPhone(companyInfo.getPhone());
        user.setEmail(companyInfo.getEmail());
        userRepository.save(user);
        return company;
    }
}
