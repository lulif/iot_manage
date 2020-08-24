package com.cw.iot.modules.app.service.impl;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cw.iot.common.utils.HttpContextUtils;

import com.cw.iot.modules.app.dao.DeviceDao;
import com.cw.iot.modules.app.dao.DeviceModelDao;
import com.cw.iot.modules.app.dao.DevicePointDao;
import com.cw.iot.modules.app.entity.TDevice;
import com.cw.iot.modules.app.entity.TDeviceModel;
import com.cw.iot.modules.app.entity.TDevicePoint;
import com.cw.iot.modules.app.form.DeviceModelSearchParams;
import com.cw.iot.modules.app.form.DevicePointSearchParams;
import com.cw.iot.modules.app.form.DeviceSearchParams;
import com.cw.iot.modules.app.service.DeviceService;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-10 21:49
 **/
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private DeviceModelDao deviceModelDao;
    @Autowired
    private DevicePointDao devicePointDao;

    @Override
    public IPage<TDevice> listDevices(DeviceSearchParams params) {
        Integer count = deviceDao.selectDevicesCount(params);
        IPage ipage = new Page<>();
        if (count > 0) {
            Integer currentPage = params.getCurrentPage();
            Integer pageSize = params.getPageSize();
            Integer start = currentPage - 1 < 0 ? 0 : currentPage - 1;
            List<TDevice> deviceList = deviceDao.listDevices(params, start * pageSize, pageSize);
            ipage.setTotal(count);
            ipage.setCurrent(currentPage);
            ipage.setSize(pageSize);
            ipage.setPages(PageUtil.totalPage(count, pageSize));
            ipage.setRecords(deviceList);
            return ipage;
        }
        ipage.setTotal(0);
        return ipage;
    }

    @Override
    public IPage<TDeviceModel> listDeviceModels(DeviceModelSearchParams params) {
        Integer state = params.getState();
        String query = params.getQuery();
        LambdaQueryWrapper wrapper = Wrappers.<TDeviceModel>lambdaQuery().ge(TDeviceModel::getRowState, 0)
                .eq(ObjectUtil.isNotNull(state), TDeviceModel::getRowState, state)
                .like(StringUtils.isNotBlank(query), TDeviceModel::getModelName, query)
                .orderByDesc(TDeviceModel::getRowModifierTime);
        Integer count = deviceModelDao.selectCount(wrapper);
        if (count > 0) {
            Page page = new Page(params.getCurrentPage(), params.getPageSize());
            return deviceModelDao.selectPage(page, wrapper);
        }
        IPage ipage = new Page<>();
        ipage.setTotal(0);
        return ipage;
    }

    @Override
    public IPage<TDevicePoint> listDevicePoints(DevicePointSearchParams params) {
        Integer count = devicePointDao.selectDevicePointsCount(params);
        IPage ipage = new Page<>();
        if (count > 0) {
            Integer currentPage = params.getCurrentPage();
            Integer pageSize = params.getPageSize();
            Integer start = currentPage - 1 < 0 ? 0 : currentPage - 1;
            List<TDevicePoint> devicePointList = devicePointDao.listDevicePoints(params, start * pageSize, pageSize);
            ipage.setTotal(count);
            ipage.setCurrent(currentPage);
            ipage.setSize(pageSize);
            ipage.setPages(PageUtil.totalPage(count, pageSize));
            ipage.setRecords(devicePointList);
            return ipage;
        }
        ipage.setTotal(0);
        return ipage;
    }


    @Override
    public TDeviceModel getDeviceModelById(String id) {
        return deviceModelDao.selectById(id);
    }

    @Override
    public TDevicePoint getDevicePointById(String id) {
        return devicePointDao.selectDevicePointById(id);
    }

    @Override
    public TDevice getDeviceById(String id) {
        return deviceDao.selectDeviceById(id);
    }


    @Override
    public Integer saveDevice(TDevice tDevice) {
        tDevice.setRowCreater(getCurrentUserName());
        tDevice.setRowModifier(getCurrentUserName());
        tDevice.setRowCreateTime(new Date());
        tDevice.setRowModifierTime(new Date());
        tDevice.setRowState(1);
        return deviceDao.insert(tDevice);
    }

    @Override
    public Integer saveDeviceModel(TDeviceModel tDeviceModel) {
        tDeviceModel.setRowCreater(getCurrentUserName());
        tDeviceModel.setRowModifier(getCurrentUserName());
        tDeviceModel.setRowCreateTime(new Date());
        tDeviceModel.setRowModifierTime(new Date());
        tDeviceModel.setRowState(1);
        return deviceModelDao.insert(tDeviceModel);
    }

    @Override
    public Integer saveDevicePoint(TDevicePoint tDevicePoint) {
        tDevicePoint.setRowCreater(getCurrentUserName());
        tDevicePoint.setRowModifier(getCurrentUserName());
        tDevicePoint.setRowCreateTime(new Date());
        tDevicePoint.setRowModifierTime(new Date());
        tDevicePoint.setRowState(1);
        return devicePointDao.insert(tDevicePoint);
    }

    @Override
    public Integer updateDevice(TDevice tDevice) {
        tDevice.setRowModifier(getCurrentUserName());
        tDevice.setRowModifierTime(new Date());
        return deviceDao.updateById(tDevice);
    }

    @Override
    public Integer updateDeviceModel(TDeviceModel tDeviceModel) {
        tDeviceModel.setRowModifier(getCurrentUserName());
        tDeviceModel.setRowModifierTime(new Date());
        return deviceModelDao.updateById(tDeviceModel);
    }

    @Override
    public Integer updateDevicePoint(TDevicePoint tDevicePoint) {
        tDevicePoint.setRowModifier(getCurrentUserName());
        tDevicePoint.setRowModifierTime(new Date());
        return devicePointDao.updateById(tDevicePoint);
    }

    @Override
    public Integer removeDevice(String id) {
        TDevice device = deviceDao.selectById(id);
        if (ObjectUtil.isNotNull(device)) {
            device.setRowState(-1);
            device.setRowModifier(getCurrentUserName());
            device.setRowModifierTime(new Date());
        }
        return deviceDao.updateById(device);
    }

    @Override
    public Integer removeDeviceModel(String id) {
        TDeviceModel deviceModel = deviceModelDao.selectById(id);
        if (ObjectUtil.isNotNull(deviceModel)) {
            deviceModel.setRowState(-1);
            deviceModel.setRowModifier(getCurrentUserName());
            deviceModel.setRowModifierTime(new Date());
        }
        return deviceModelDao.updateById(deviceModel);
    }

    @Override
    public Integer removeDevicePoint(String id) {
        TDevicePoint devicePoint = devicePointDao.selectById(id);
        if (ObjectUtil.isNotNull(devicePoint)) {
            devicePoint.setRowState(-1);
            devicePoint.setRowModifier(getCurrentUserName());
            devicePoint.setRowModifierTime(new Date());
        }
        return devicePointDao.updateById(devicePoint);
    }

    @Override
    public List<TDeviceModel> getAllDeviceModel() {
        LambdaQueryWrapper wrapper = Wrappers.<TDeviceModel>lambdaQuery().ge(TDeviceModel::getRowState, 0);
        return deviceModelDao.selectList(wrapper);
    }


    private String getCurrentUserName() {
        String userName = (String) HttpContextUtils.getSession().getAttribute("currentUser");
        return userName;
    }
}
