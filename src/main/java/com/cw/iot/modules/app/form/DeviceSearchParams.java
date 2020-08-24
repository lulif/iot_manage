package com.cw.iot.modules.app.form;

import com.cw.iot.modules.app.bean.PageListParams;
import lombok.Data;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-10 22:38
 **/
@Data
public class DeviceSearchParams extends PageListParams {
    private Integer deviceModel;
    private Integer state;
}
