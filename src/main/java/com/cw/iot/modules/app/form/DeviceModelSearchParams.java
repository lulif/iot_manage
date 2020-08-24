package com.cw.iot.modules.app.form;

import com.cw.iot.modules.app.bean.PageListParams;
import lombok.Data;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-22 13:21
 **/
@Data
public class DeviceModelSearchParams extends PageListParams {
    private Integer state;
}
