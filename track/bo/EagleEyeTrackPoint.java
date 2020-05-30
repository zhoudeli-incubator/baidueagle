package com.chinavisionary.link.app.track.bo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EagleEyeTrackPoint {

    /**
     * 	entity名称，作为其唯一标识
     */
    private String entityName;

    /**
     * 纬度
     */
    private double latitude;

    /**
     * 经度
     */
    private double longitude;

    /**
     * 时间UNIX 时间戳 十位如 1589801794
     */
    private int locTime;
}
