package com.cw.iot.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cw.iot.modules.app.entity.TDevicePoint;
import com.cw.iot.modules.app.form.DevicePointSearchParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-10 21:47
 **/
@Mapper
public interface DevicePointDao extends BaseMapper<TDevicePoint> {
    List<TDevicePoint> listDevicePoints(@Param("params") DevicePointSearchParams params, @Param("limit") Integer limit, @Param("length") Integer length);

    Integer selectDevicePointsCount(DevicePointSearchParams params);

    TDevicePoint selectDevicePointById(String id);
}
