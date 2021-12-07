package com.shixi.heima_mm.service.impl;

import com.shixi.heima_mm.service.IUserAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserAdminServiceImplTest {
    @Autowired
    IUserAdminService iUserAdminService;

    @Test
    void adminLogin() {
        System.out.println(iUserAdminService.login("admin", "admin"));
    }
}