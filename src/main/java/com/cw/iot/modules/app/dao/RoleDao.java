package com.cw.iot.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cw.iot.modules.app.entity.TRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-15 22:17
 **/
@Mapper
public interface RoleDao extends BaseMapper<TRole> {
}
