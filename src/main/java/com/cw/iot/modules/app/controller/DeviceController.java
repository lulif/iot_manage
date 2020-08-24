package com.cw.iot.modules.app.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cw.iot.common.utils.R;

import com.cw.iot.modules.app.entity.TDevice;
import com.cw.iot.modules.app.entity.TDeviceModel;
import com.cw.iot.modules.app.entity.TDevicePoint;
import com.cw.iot.modules.app.form.DeviceModelSearchParams;
import com.cw.iot.modules.app.form.DevicePointSearchParams;
import com.cw.iot.modules.app.form.DeviceSearchParams;
import com.cw.iot.modules.app.service.DeviceService;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-10 21:51
 **/
@Slf4j
@RestController
@RequestMapping("/device")
@Api("IOT设备接口")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping("/getDeviceList")
    @ApiOperation("获取设备列表信息")
    public R getDeviceList(DeviceSearchParams params) {
        Map<String, Object> resMap = Maps.newLinkedHashMap();
        resMap.put("total", 0);
        IPage<TDevice> res = deviceService.listDevices(params);
        if (res.getTotal() > 0) {
            resMap.put("total", res.getTotal());
            resMap.put("totalPage", res.getPages());
            resMap.put("list", res.getRecords());
            resMap.put("currentPage", res.getCurrent());
            resMap.put("pageSize", res.getSize());
        }
        return R.ok(resMap);
    }

    @PostMapping("/getDeviceModelList")
    @ApiOperation("获取设备类型列表信息")
    public R getDeviceModelList(DeviceModelSearchParams params) {
        Map<String, Object> resMap = Maps.newLinkedHashMap();
        resMap.put("total", 0);
        IPage<TDeviceModel> res = deviceService.listDeviceModels(params);
        if (res.getTotal() > 0) {
            resMap.put("total", res.getTotal());
            resMap.put("totalPage", res.getPages());
            resMap.put("list", res.getRecords());
            resMap.put("currentPage", res.getCurrent());
            resMap.put("pageSize", res.getSize());
        }
        return R.ok(resMap);
    }

    @PostMapping("/getDevicePointList")
    @ApiOperation("获取设备点位列表信息")
    public R getDevicePointList(DevicePointSearchParams deviceManageParams) {
        Map<String, Object> resMap = Maps.newLinkedHashMap();
        resMap.put("total", 0);
        IPage<TDevicePoint> res = deviceService.listDevicePoints(deviceManageParams);
        if (res.getTotal() > 0) {
            resMap.put("total", res.getTotal());
            resMap.put("totalPage", res.getPages());
            resMap.put("list", res.getRecords());
            resMap.put("currentPage", res.getCurrent());
            resMap.put("pageSize", res.getSize());
        }
        return R.ok(resMap);
    }

    @PostMapping("/getDeviceById")
    @ApiOperation("获取设备信息")
    public R getDeviceById(String id) {
        TDevice device = deviceService.getDeviceById(id);
        return R.ok("device", device);
    }

    @PostMapping("/getDeviceModelById")
    @ApiOperation("获取设备类型信息")
    public R getDeviceModelById(String id) {
        TDeviceModel deviceModel = deviceService.getDeviceModelById(id);
        return R.ok("deviceModel", deviceModel);
    }

    @PostMapping("/getDevicePointById")
    @ApiOperation("获取设备点位信息")
    public R getDevicePointById(String id) {
        TDevicePoint devicePoint = deviceService.getDevicePointById(id);
        return R.ok("devicePoint", devicePoint);
    }

    @PostMapping("/addDevice")
    @ApiOperation("新增设备信息")
    public R addDevice(TDevice device) {
        Integer res = deviceService.saveDevice(device);
        if (res > 0) {
            return R.ok();
        }
        return R.error("新增设备失败");
    }

    @PostMapping("/addDeviceModel")
    @ApiOperation("新增设备类型信息")
    public R addDeviceModel(TDeviceModel deviceModel) {
        Integer res = deviceService.saveDeviceModel(deviceModel);
        if (res > 0) {
            return R.ok();
        }
        return R.error("新增设备类型失败");
    }

    @PostMapping("/addDevicePoint")
    @ApiOperation("新增设备点位信息")
    public R addDevicePoint(TDevicePoint devicePoint) {
        Integer res = deviceService.saveDevicePoint(devicePoint);
        if (res > 0) {
            return R.ok();
        }
        return R.error("新增设备点位失败");
    }

    @PostMapping("/modifyDevice")
    @ApiOperation("修改设备信息")
    public R modifyDevice(TDevice device) {
        Integer res = deviceService.updateDevice(device);
        if (res > 0) {
            return R.ok();
        }
        return R.error("修改设备信息失败");
    }

    @PostMapping("/modifyDeviceModel")
    @ApiOperation("修改设备类型信息")
    public R modifyDeviceModel(TDeviceModel deviceModel) {
        Integer res = deviceService.updateDeviceModel(deviceModel);
        if (res > 0) {
            return R.ok();
        }
        return R.error("修改设备类型信息失败");
    }

    @PostMapping("/modifyDevicePoint")
    @ApiOperation("修改设备点位信息")
    public R modifyDevicePoint(TDevicePoint devicePoint) {
        Integer res = deviceService.updateDevicePoint(devicePoint);
        if (res > 0) {
            return R.ok();
        }
        return R.error("修改设备点位信息失败");
    }

    @PostMapping("/removeDevice")
    @ApiOperation("删除设备信息")
    public R removeDevice(String id) {
        Integer res = deviceService.removeDevice(id);
        if (res > 0) {
            return R.ok();
        }
        return R.error("删除设备信息失败");
    }

    @PostMapping("/removeDeviceModel")
    @ApiOperation("删除设备类型信息")
    public R removeDeviceModel(String id) {
        Integer res = deviceService.removeDeviceModel(id);
        if (res > 0) {
            return R.ok();
        }
        if (res == -100) {
            return R.error("删除前,请修改已依赖此类型的设备信息");
        }
        return R.error("删除设备类型信息失败");
    }

    @PostMapping("/removeDevicePoint")
    @ApiOperation("删除设备点位信息")
    public R removeDevicePoint(String id) {
        Integer res = deviceService.removeDevicePoint(id);
        if (res > 0) {
            return R.ok();
        }
        if (res == -100) {
            return R.error("删除前,请修改已依赖此点位的设备信息");
        }
        return R.error("删除设备点位信息失败");
    }

    @PostMapping("/getAllDeviceModel")
    @ApiOperation("获取所有设备类型")
    public R getAllDeviceModel() {
        List<TDeviceModel> allDeviceModelList = deviceService.getAllDeviceModel();
        return R.ok("allDeviceModel", allDeviceModelList);
    }
}
