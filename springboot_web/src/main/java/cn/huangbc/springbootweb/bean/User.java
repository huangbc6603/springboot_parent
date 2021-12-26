package cn.huangbc.springbootweb.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author huangbc
 * @version 1.0
 * @date 2021/12/21 8:34
 */
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {

    @NotNull
    @ApiModelProperty(value = "用户id")
    @Min(value = 2,message = "大于等于2")
    @Max(value = 100 ,message = "最大不能超过100")
    private Integer id;

    @Length(min = 2, max = 10)
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户地址")
    private String address;

}
