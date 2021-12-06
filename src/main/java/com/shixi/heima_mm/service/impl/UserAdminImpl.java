package com.shixi.heima_mm.service.impl;

import com.shixi.heima_mm.pojo.UserAdmin;
import com.shixi.heima_mm.repository.UserAdminDao;
import com.shixi.heima_mm.service.IUserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAdminImpl implements IUserAdminService {
    @Autowired
    private UserAdminDao userAdminDao;

    @Override
    public UserAdmin adminLogin(String name, String password) {

        Optional<UserAdmin> op = userAdminDao.findOne(
                (root, cq, cb) -> cb.and(
                        cb.equal(root.get("name"), name),
                        cb.equal(root.get("password"), password)
                )
        );

        if(op.isPresent()) {
            return op.get();
        } else  {
            return null;
        }
    }

    @Override
    public UserAdmin insert(UserAdmin userAdmin) {
        return userAdminDao.save(userAdmin);
    }

    @Override
    public UserAdmin update(UserAdmin userAdmin) {
        return userAdminDao.save(userAdmin);
    }

    @Override
    public void delById(int id) {
        userAdminDao.deleteById(id);
    }


//    @Override
//    public String adminLogin(HttpSession session, UserAdmin userAdmin) {
//        UserAdmin userId=userAdminDao.findById(userAdmin.getId());
//        String password=userAdminDao.findById(userId.toString()).getPassword();
//        if(userId!=null){
//            session.setAttribute("userAdmin",userAdmin);
//            return "Ok";
//        }else {
//            return "error";
//        }
//
//    }
}
