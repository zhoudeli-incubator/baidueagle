package com.chinavisionary.link.app.track.config;

import lombok.Setter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "baidu.eagle")
public class BaiduEagleEyeProperties {

    private static final String EAGLEEYE_AK = "ERGvuThjtLRfX3ZR95HynKHdD0wgEns7";
    private static final String EAGLEEYE_SERVICE_ID = "221324";
    private static final String EAGLEEYE_COORD_TYPE_INPUT = "bd09ll";
    private static final String EAGLEEYE_HOST_URL = "http://yingyan.baidu.com/api/v3";
    private static final String EAGLEEYE_ENTITY_ADD_PATH = "/entity/add";
    private static final String EAGLEEYE_TRACK_ADD_POINT_PATH = "/track/addpoint";
    private static final String EAGLEEYE_TRACK_GET_POINT_PATH = "/track/gettrack";
    private static final String EAGLEEYE_ENTITY_DESC = "小和师傅";

    /**
     * 用户的AK，授权使用
     */
    @Setter
    private String ak;

    /**
     * service的ID，service 的唯一标识
     */
    @Setter
    private String serviceId;

    /**
     * 默认值：bd09ll
     * 该字段用于描述上传的坐标类型。可选值为：
     * wgs84：GPS 坐标
     * gcj02：国测局加密坐标
     * bd09ll：百度经纬度坐标
     */
    @Setter
    private String coordTypeInput;

    /**
     * 百度鹰眼地址
     */
    @Setter
    private String hostUrl;

    /**
     * Path: 增加Entity
     */
    @Setter
    private String entityAddPath;

    /**
     * Path: 增加轨迹点
     */
    @Setter
    private String trackAddPointPath;
    /**
     * Path: 查询轨迹点
     */
    @Setter
    private String trackGetPointListPath;

    /**
     * Entity 描述
     * @return
     */
    @Setter
    private String entityDesc;

    public String getAk() {
        if(Strings.isBlank(ak))
            ak = EAGLEEYE_AK;
        return ak;
    }

    public String getServiceId() {
        if(Strings.isBlank(serviceId))
            serviceId = EAGLEEYE_SERVICE_ID;
        return serviceId;
    }

    public String getCoordTypeInput() {
        if(Strings.isBlank(coordTypeInput))
            coordTypeInput = EAGLEEYE_COORD_TYPE_INPUT;
        return coordTypeInput;
    }

    public String getHostUrl() {
        if(Strings.isBlank(hostUrl))
            hostUrl = EAGLEEYE_HOST_URL;
        return hostUrl;
    }

    public String getEntityAddPath() {
        if(Strings.isBlank(entityAddPath))
            entityAddPath = EAGLEEYE_ENTITY_ADD_PATH;
        return entityAddPath;
    }

    public String getTrackAddPointPath() {
        if(Strings.isBlank(trackAddPointPath))
            trackAddPointPath = EAGLEEYE_TRACK_ADD_POINT_PATH;
        return trackAddPointPath;
    }

    public String getTrackGetPointListPath() {
        if(Strings.isBlank(trackGetPointListPath))
            trackGetPointListPath = EAGLEEYE_TRACK_GET_POINT_PATH;
        return trackGetPointListPath;
    }

    public String getEntityDesc() {
        if(Strings.isBlank(entityDesc))
            entityDesc = EAGLEEYE_ENTITY_DESC;
        return entityDesc;
    }

    @Override
    public String toString() {
        return "BaiduEagleEyeProperties{" +
                "ak='" + ak + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", coordTypeInput='" + coordTypeInput + '\'' +
                ", hostUrl='" + hostUrl + '\'' +
                ", entityAddPath='" + entityAddPath + '\'' +
                ", trackAddpointPath='" + trackAddPointPath + '\'' +
                ", trackGettrackPath='" + trackGetPointListPath + '\'' +
                '}';
    }
}
