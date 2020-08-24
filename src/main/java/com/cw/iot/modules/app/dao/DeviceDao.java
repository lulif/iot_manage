package com.cw.iot.modules.app.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cw.iot.modules.app.entity.TDevice;
import com.cw.iot.modules.app.form.DeviceSearchParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-10 21:46
 **/
@Mapper
public interface DeviceDao extends BaseMapper<TDevice> {
    List<TDevice> listDevices(@Param("params") DeviceSearchParams params, @Param("limit") Integer limit, @Param("length") Integer length);

    Integer selectDevicesCount(DeviceSearchParams params);

    TDevice selectDeviceById(String id);
}
