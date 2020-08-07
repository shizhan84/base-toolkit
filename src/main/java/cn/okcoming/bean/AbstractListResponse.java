package cn.okcoming.bean;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;


public abstract class AbstractListResponse<T> extends BaseResult {
    @ApiModelProperty(value = "总数量")
    private Integer totalCount;

    public abstract List<T> getResult();

    @Override
    public String toString() {
        return "AbstractListResponse{" +
                "totalCount=" + totalCount +
                "} " + super.toString();
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }


}
