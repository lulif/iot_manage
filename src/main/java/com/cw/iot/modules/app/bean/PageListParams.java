package com.cw.iot.modules.app.bean;

import lombok.Data;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-22 13:19
 **/
@Data
public class PageListParams {
    protected String query;
    protected Integer currentPage = 1;
    protected Integer pageSize = 25;
    protected String sortName;
    protected String sortOrder;
}
