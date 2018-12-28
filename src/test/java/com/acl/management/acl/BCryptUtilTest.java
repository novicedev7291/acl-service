package com.acl.management.acl;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtilTest {
    @Test
    public void shouldProduceValidBCryptHash(){
        System.out.println(new BCryptPasswordEncoder(12).encode("P@ssw111rd"));
    }
}
