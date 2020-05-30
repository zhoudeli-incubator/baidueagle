package com.chinavisionary.link.app.track.service.impl;

import com.chinavisionary.framework.starter.common.context.SystemContext;
import com.chinavisionary.framework.starter.common.utils.UUIDUtils;
import com.chinavisionary.framework.starter.common.vo.ResultVo;
import com.chinavisionary.link.app.track.bo.EagleEyeEntity;
import com.chinavisionary.link.app.track.bo.EagleEyeTrackPoint;
import com.chinavisionary.link.app.track.config.BaiduEagleEyeProperties;
import com.chinavisionary.link.app.track.dto.EagleEyeReturnDto;
import com.chinavisionary.link.app.track.dto.EagleEyeTrackPointListReturnDto;
import com.chinavisionary.link.app.track.param.EagleEyeEntityCreateParam;
import com.chinavisionary.link.app.track.param.EagleEyeTrackCreateParam;
import com.chinavisionary.link.app.track.param.EagleEyeTrackQueryParam;
import com.chinavisionary.link.app.track.service.EagleEyeService;
import com.chinavisionary.link.app.track.util.RequestParameterUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Objects;

@Service
public class EagleEyeServiceImpl implements EagleEyeService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private BaiduEagleEyeProperties baiduEagleEyeProperties;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ResultVo addEntity() {
        EagleEyeEntity eagleEyeEntity = new EagleEyeEntity();

        String entityName = UUIDUtils.getUuid();
        eagleEyeEntity.setEntityName(entityName);
        eagleEyeEntity.setEntityDesc(baiduEagleEyeProperties.getEntityDesc());

        // 提取接口调用参数
        EagleEyeEntityCreateParam entityCreateParam = new EagleEyeEntityCreateParam();
        BeanUtils.copyProperties(eagleEyeEntity, entityCreateParam);
        entityCreateParam.setAk(baiduEagleEyeProperties.getAk());
        entityCreateParam.setServiceId(baiduEagleEyeProperties.getServiceId());

        // 上传到百度鹰眼
        ResponseEntity<String> responseEntity = restTemplate.exchange(String.format("%s%s", baiduEagleEyeProperties.getHostUrl(), baiduEagleEyeProperties.getEntityAddPath()),
                HttpMethod.POST, RequestParameterUtil.requestEntityForPost(entityCreateParam), String.class);

        // 解析结果
        EagleEyeReturnDto returnDto;
        try {
            returnDto = objectMapper.readValue(responseEntity.getBody(), EagleEyeReturnDto.class);
        } catch (IOException e) {
            returnDto = new EagleEyeReturnDto(1, String.format("结果解析失败[%s]", e.getMessage()));
            e.printStackTrace();
        }
        if(Objects.isNull(returnDto) || returnDto.getStatus() != 0)
            return new ResultVo(false, String.format("创建Entity失败[%s]", Objects.isNull(returnDto) ? "" : returnDto.getMessage()));

        return new ResultVo(true, "创建Entity 成功", entityName);
    }

    @Override
    public ResultVo addTrackPoint(EagleEyeTrackPoint eagleEyeTrackPoint) {

        // 提取接口调用参数
        EagleEyeTrackCreateParam trackCreateParam = new EagleEyeTrackCreateParam();
        BeanUtils.copyProperties(eagleEyeTrackPoint, trackCreateParam);
        trackCreateParam.setAk(baiduEagleEyeProperties.getAk());
        trackCreateParam.setServiceId(baiduEagleEyeProperties.getServiceId());
        trackCreateParam.setCoordTypeInput(baiduEagleEyeProperties.getCoordTypeInput());

        // 上传到百度鹰眼
        ResponseEntity<String> responseEntity = restTemplate.exchange(String.format("%s%s", baiduEagleEyeProperties.getHostUrl(), baiduEagleEyeProperties.getTrackAddPointPath()),
                HttpMethod.POST, RequestParameterUtil.requestEntityForPost(trackCreateParam), String.class);

        // 解析结果
        EagleEyeReturnDto returnDto;
        try {
            returnDto = objectMapper.readValue(responseEntity.getBody(), EagleEyeReturnDto.class);
        } catch (IOException e) {
            returnDto = new EagleEyeReturnDto(1, String.format("结果解析失败[%s]", e.getMessage()));
            e.printStackTrace();
        }

        if(Objects.isNull(returnDto) || returnDto.getStatus() != 0)
            new ResultVo(false, String.format("上传轨迹失败[%s]", Objects.isNull(returnDto) ? "" : returnDto.getMessage()));

        return new ResultVo(true, "上传轨迹成功");
    }

    @Override
    public EagleEyeTrackPointListReturnDto getTrackPointList(EagleEyeTrackQueryParam trackQueryParam) {

        if(Strings.isBlank(trackQueryParam.getAk()))
            trackQueryParam.setAk(baiduEagleEyeProperties.getAk());
        if(Strings.isBlank(trackQueryParam.getServiceId()))
            trackQueryParam.setServiceId(baiduEagleEyeProperties.getServiceId());

        // 参数校验
        if(Strings.isBlank(trackQueryParam.getEntityName())) {
            EagleEyeTrackPointListReturnDto returnDto = new EagleEyeTrackPointListReturnDto();
            returnDto.setStatus(0);
            returnDto.setMessage("Entity Name 不能为空");
            return returnDto;
        }
        // 上传到百度鹰眼
        ResponseEntity<String> responseEntity = restTemplate.exchange(RequestParameterUtil.requestUrlForGet(String.format("%s%s", baiduEagleEyeProperties.getHostUrl(), baiduEagleEyeProperties.getTrackGetPointListPath()), trackQueryParam),
                HttpMethod.GET, RequestParameterUtil.requestEntityForGet(), String.class);

        // 解析结果
        EagleEyeTrackPointListReturnDto returnDto;
        try {
            returnDto = objectMapper.readValue(responseEntity.getBody(), EagleEyeTrackPointListReturnDto.class);
        } catch (IOException e) {
            returnDto = new EagleEyeTrackPointListReturnDto(1, String.format("结果解析失败[%s]", e.getMessage()));
            e.printStackTrace();
        }
        if(Objects.isNull(returnDto) || returnDto.getStatus() != 0)
            new ResultVo(false, String.format("上传轨迹失败[%s]", Objects.isNull(returnDto) ? "" : returnDto.getMessage()));

        return returnDto;
    }
}
