package com.cw.iot.modules.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-15 22:15
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("T_ROLE")
public class TRole {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String roleName;
    private String remark;
    private Date rowCreateTime;
    private Integer rowState;
    private Date rowModifierTime;
}
