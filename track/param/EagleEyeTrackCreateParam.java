package com.chinavisionary.link.app.track.param;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EagleEyeTrackCreateParam {


    /**
     * 用户的AK，授权使用
     */
    private String ak;

    /**
     * service的ID，service 的唯一标识
     */
    private String serviceId;

    /**
     * 	entity名称，作为其唯一标识
     */
    private String entityName;

    /**
     * 经度
     */
    private double latitude;

    /**
     * 纬度
     */
    private double longitude;

    /**
     * 时间UNIX 时间戳 十位如 1589801794
     * UnixDateUtil.getUnixTimeStamp(new Date())
     */
    private int locTime;
    /**
     * 默认值：bd09ll
     * 该字段用于描述上传的坐标类型。可选值为：
     * wgs84：GPS 坐标
     * gcj02：国测局加密坐标
     * bd09ll：百度经纬度坐标
     */
    private String coordTypeInput = "bd09ll";
}
