package com.janwes.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes.pojo
 * @date 2021/7/21 13:48
 * @description
 */
@ApiModel(value = "地理位置信息")
@Data
@TableName("location")
public class Location implements Serializable {

    private static final long serialVersionUID = 142087655870664400L;

    @ApiModelProperty(value = "主键id", hidden = true)
    @TableId("id")
    private int id;

    @ApiModelProperty(value = "地址", required = true, example = "深圳北站")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "经度", required = true, example = "114.035529")
    @TableField("longitude")
    private Double longitude;

    @ApiModelProperty(value = "纬度", required = true, example = "22.615108")
    @TableField("latitude")
    private Double latitude;
}
