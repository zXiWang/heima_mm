package com.shixi.heima_mm.service;

import com.shixi.heima_mm.pojo.UserAdmin;

public interface IUserAdminService {

    UserAdmin login(String name, String password);

    UserAdmin insert(UserAdmin userAdmin);

    UserAdmin update(UserAdmin userAdmin);

    boolean findByName(String name);

    void delById(int id);

    boolean findById(Integer id);
}
