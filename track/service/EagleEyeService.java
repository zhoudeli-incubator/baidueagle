package com.chinavisionary.link.app.track.service;

import com.chinavisionary.framework.starter.common.vo.ResultVo;
import com.chinavisionary.link.app.track.bo.EagleEyeTrackPoint;
import com.chinavisionary.link.app.track.dto.EagleEyeTrackPointListReturnDto;
import com.chinavisionary.link.app.track.param.EagleEyeTrackQueryParam;

/**
 * 百度鹰眼接口封装
 */
public interface EagleEyeService {

    /**
     * 增加Entity
     * @return
     */
    ResultVo addEntity();

    /**
     * 上传轨迹点
     * @param eagleEyeTrackPoint
     * @return
     */
    ResultVo addTrackPoint(EagleEyeTrackPoint eagleEyeTrackPoint);

    /**
     * 轨迹查询
     */

    EagleEyeTrackPointListReturnDto getTrackPointList(EagleEyeTrackQueryParam trackQueryParam);
}
