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
public class EagleEyeEntityCreateParam {


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
     * entity 的可读性描述
     */
    private String entityDesc;

}
