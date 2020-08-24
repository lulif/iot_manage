package com.cw.iot.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cw.iot.modules.app.entity.TDeviceModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-10 21:46
 **/
@Mapper
public interface DeviceModelDao extends BaseMapper<TDeviceModel> {
}
