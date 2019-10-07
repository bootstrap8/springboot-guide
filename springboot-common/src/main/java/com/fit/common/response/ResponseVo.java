package com.fit.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-05
 */
@Data
@ApiModel(description = "基础Vo")
public class ResponseVo<T> {

    @ApiModelProperty(value = "响应码 1成功 0失败")
    private int code;
    @ApiModelProperty(value = "响应消息")
    private String msg;
    @ApiModelProperty(value = "数据")
    private T data;

    public static <T> ResponseVo okFrom(T data) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setCode(1);
        responseVo.setMsg("OK");
        responseVo.setData(data);
        return responseVo;
    }

    public static ResponseVo failWith(String msg) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setCode(0);
        responseVo.setMsg(msg);
        return responseVo;
    }
}
