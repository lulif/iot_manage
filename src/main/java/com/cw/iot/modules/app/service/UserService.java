package com.cw.iot.modules.app.service;


import com.cw.iot.modules.app.entity.TRole;
import com.cw.iot.modules.app.entity.TUser;

import java.util.List;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-15 15:49
 **/
public interface UserService {
    Integer checkLogin(String userName, String password);

    List<TUser> getUserList();

    Integer saveUser(TUser user);

    Integer updateUser(TUser user);

    Integer removeUser(String userId);

    List<TRole> getAllRoleList();

    TUser getUserById(String id);

    Integer removeRole(String id);
}
