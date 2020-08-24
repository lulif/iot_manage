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
 * @create 2020-08-15 15:46
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("T_USER")
public class TUser {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String password;
    private Date rowCreateTime;
    private Integer rowState;
    private String role;
    private String remark;
    private String rowCreater;
    private String rowModifier;
    private Date rowModifierTime;
}
