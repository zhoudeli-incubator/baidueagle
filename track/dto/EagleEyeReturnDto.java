package com.chinavisionary.link.app.track.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EagleEyeReturnDto {

    /**
     * 返回状态，0为成功
     */
    private int status;

    /**
     * 对status的中文描述
     */
    private String message;
}
