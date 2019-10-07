package com.fit.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-10-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "分页")
public class PageVo<T> {
    @ApiModelProperty(value = "记录数")
    private Long totalRecords;
    @ApiModelProperty(value = "结果集")
    private List<T> list;

}
