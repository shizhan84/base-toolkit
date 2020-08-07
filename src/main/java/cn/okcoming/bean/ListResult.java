package cn.okcoming.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;


public class ListResult<T> extends BaseResult {

    @ApiModelProperty(value = "返回数据")
    private List<T> data;

    @Override
    public String toString() {
        return "ListResult{" +
                "data=" + data +
                "} " + super.toString();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
