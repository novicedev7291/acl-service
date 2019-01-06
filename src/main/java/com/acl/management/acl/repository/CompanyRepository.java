package com.acl.management.acl.repository;

import com.acl.management.acl.model.Companies;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Companies, Integer>{
}
