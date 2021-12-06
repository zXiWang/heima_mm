package com.shixi.heima_mm.service;

import com.shixi.heima_mm.pojo.UserAdmin;

public interface IUserAdminService {

    UserAdmin adminLogin(String name, String password);

    UserAdmin insert(UserAdmin userAdmin);

    UserAdmin update(UserAdmin userAdmin);

    void delById(int id);
}
