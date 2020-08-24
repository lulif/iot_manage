package com.cw.iot.modules.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cw.iot.modules.app.entity.TDevice;
import com.cw.iot.modules.app.entity.TDeviceModel;
import com.cw.iot.modules.app.entity.TDevicePoint;
import com.cw.iot.modules.app.form.DeviceModelSearchParams;
import com.cw.iot.modules.app.form.DevicePointSearchParams;
import com.cw.iot.modules.app.form.DeviceSearchParams;

import java.util.List;


/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-10 21:50
 **/
public interface DeviceService {

    IPage<TDevice> listDevices(DeviceSearchParams params);

    IPage<TDeviceModel> listDeviceModels(DeviceModelSearchParams params);

    IPage<TDevicePoint> listDevicePoints(DevicePointSearchParams params);

    TDevice getDeviceById(String id);

    TDeviceModel getDeviceModelById(String id);

    TDevicePoint getDevicePointById(String id);

    Integer saveDevice(TDevice tDevice);

    Integer saveDeviceModel(TDeviceModel tDeviceModel);

    Integer saveDevicePoint(TDevicePoint tDevicePoint);

    Integer updateDevice(TDevice tDevice);

    Integer updateDeviceModel(TDeviceModel tDeviceModel);

    Integer updateDevicePoint(TDevicePoint tDevicePoint);

    Integer removeDevice(String id);

    Integer removeDeviceModel(String id);

    Integer removeDevicePoint(String id);

    List<TDeviceModel> getAllDeviceModel();


}
