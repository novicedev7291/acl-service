package com.acl.management.acl.repository;

import com.acl.management.acl.model.Users;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<Users, Integer>{
    Users findByCompanyIdAndUsernameAndActive(String companyId, String username, boolean active);
}
