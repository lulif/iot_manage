package com.cw.iot.modules.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

import java.util.Date;


/**
 * <p>
 *
 * </p>
 *
 * @author lulif
 * @since 2020-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("T_DEVICE")
public class TDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备型号
     */
    private String deviceModel;

    /**
     * 设备位置
     */
    private String devicePosition;

    /**
     * 创建人
     */
    private String rowCreater;

    /**
     * 创建时间
     */
    private Date rowCreateTime;

    /**
     * 最后更新人
     */
    private String rowModifier;

    /**
     * 最后更新时间
     */
    private Date rowModifierTime;

    /**
     * 状态 0：禁用 1：正常
     */
    private Integer rowState;

    /**
     * 英文标识
     */
    private String identifyEn;


}
