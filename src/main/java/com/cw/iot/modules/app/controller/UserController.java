package com.cw.iot.modules.app.controller;

import com.cw.iot.common.utils.R;

import com.cw.iot.modules.app.entity.TUser;
import com.cw.iot.modules.app.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-15 15:46
 **/
@Slf4j
@RestController
@RequestMapping("/user")
@Api("用户接口")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("用户登陆校验")
    public R CheckLogin(HttpSession session, String userName, String password) {
        Integer res = userService.checkLogin(userName, password);
        if (res == 1) {
            session.setAttribute("currentUser", userName);
            return R.ok();
        }
        if (res == -1) {
            return R.error("用户不存在或已禁用");
        }
        return R.error("用户名或密码错误");
    }

    @PostMapping("/getUserList")
    @ApiOperation("获取用户列表")
    public R getUserList() {
        List<TUser> userDTOS = userService.getUserList();
        return R.ok("userList", userDTOS);
    }

    @PostMapping("/addUser")
    @ApiOperation("新增用户")
    public R addUser(TUser user) {
        Integer res = userService.saveUser(user);
        if (res > 0) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("/modifyUser")
    @ApiOperation("修改用户")
    public R modifyUser(TUser user) {
        Integer res = userService.updateUser(user);
        if (res > 0) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("/removeUser")
    @ApiOperation("删除用户")
    public R removeUser(String id) {
        Integer res = userService.removeUser(id);
        if (res > 0) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("/getUserById")
    @ApiOperation("修改用户")
    public R getUserById(String id) {
        return R.ok("user", userService.getUserById(id));
    }

    @PostMapping("/getAllRoleList")
    @ApiOperation("获取所有角色")
    public R getAllRoleList() {
        return R.ok("allRoleList", userService.getAllRoleList());
    }

    @PostMapping("/removeRole")
    @ApiOperation("删除角色角色")
    public R removeRole(String id) {
        if (userService.removeRole(id) > 0) {
            return R.ok();
        }
        return R.error();
    }
}
