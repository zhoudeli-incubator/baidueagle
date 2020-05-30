package com.chinavisionary.link.app.track.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EagleEyeTrackPointListReturnDto extends EagleEyeReturnDto{

    public EagleEyeTrackPointListReturnDto(int status, String message){
        super(status, message);
    }
    /**
     * 返回的结果条数-当前页
     */
    private int size;

    /**
     * 此段轨迹的里程数-当前页
     */
    private double distance;

    /**
     * 起点信息
     */
    private EagleEyeTrackPointDto startPoint;

    /**
     * 终点信息
     */
    private EagleEyeTrackPointDto endPoint;

    /**
     * 历史轨迹点列表
     */
    private List<EagleEyeTrackPointDto> points = Lists.newArrayList();
}
