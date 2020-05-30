package com.chinavisionary.link.app.track.param;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EagleEyeTrackQueryParam {


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
     * 轨迹开始时间, Unix 时间戳
     * UnixDateUtil.getUnixTimeStamp(new Date())
     */
    private int startTime;

    /**
     * 轨迹结束时间, Unix 时间戳
     * UnixDateUtil.getUnixTimeStamp(new Date())
     */
    private int endTime;

    /**
     * 是否返回纠偏后轨迹
     * 默认值：0
     * 取值规则：
     * 0：关闭轨迹纠偏，返回原始轨迹
     * 1：打开轨迹纠偏，返回纠偏后轨迹
     */
    private int isProcessed;

    /**
     * 纠偏选项
     * 仅在is_processed=1时生效。默认值为：
     * denoise_grade=1,need_mapmatch=0,transport_mode=auto,vacuate_grade=1
     *
     * 取值规则为：
     *
     * 1.去噪 denoise_grade（去噪力度）取值范围[0,5]，数值越大去噪力度越大，代表越多的点会被当做噪点去除。若取值0，则代表不去噪。
     * 示例：
     * denoise_grade:0 （不去噪）
     * denoise_grade:1 （系统默认去噪）
     * denoise_grade:2（系统默认去噪，同时去除定位精度低于500的轨迹点，相当于保留GPS定位点、大部分Wi-Fi定位点和精度较高的基站定位点）
     * denoise_grade:3（系统默认去噪，同时去除定位精度低于100的轨迹点，相当于保留GPS定位点和大部分Wi-Fi定位点）
     * denoise_grade:4（系统默认去噪，同时去除定位精度低于50的轨迹点，相当于保留GPS定位点和精度较高的Wi-Fi定位点）
     * denoise_grade:5（系统默认去噪，同时去除定位精度低于20的轨迹点，相当于仅保留GPS定位点）
     *
     * 2.绑路，示例：
     *
     * need_mapmatch=0：不绑路
     *
     * need_mapmatch=1：绑路
     *
     * 3.交通方式，鹰眼将根据不同交通工具选择不同的纠偏策略和参数，目前支持：自动（即鹰眼自动识别的交通方式）、驾车、骑行和步行，示例：
     *
     * transport_mode=auto
     * transport_mode=driving
     *
     * transport_mode=riding
     *
     * transport_mode=walking
     *
     * 4.抽稀 取值范围[0,5]，数值越大抽稀度力度越大，代表轨迹会越稀疏。若取值0，则代表不抽稀。
     * 示例： vacuate_grade:0（不抽稀） vacuate_grade:2（抽稀力度为2）
     */
    private String processOption;
}
