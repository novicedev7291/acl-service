package com.acl.management.acl.repository;

import com.acl.management.acl.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    Users findByCompanyIdAndUsernameAndActive(String companyId, String username, boolean active);
}
