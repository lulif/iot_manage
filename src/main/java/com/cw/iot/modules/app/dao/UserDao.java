package com.cw.iot.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.cw.iot.modules.app.entity.TUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-15 15:48
 **/
@Mapper
public interface UserDao extends BaseMapper<TUser> {
    List<TUser> listUsers();

    TUser getUserById(String id);
}
