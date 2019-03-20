package cn.okcoming.basebean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public abstract class AbstractListResponse<T> extends BaseResult {
    @ApiModelProperty(value = "总数量")
    private Integer totalCount;

    public abstract List<T> getResult();
}
