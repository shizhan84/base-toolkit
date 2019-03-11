package cn.okcoming.basebean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 瀑布流方式调用
 * 事先不统计总数量，响应速度更快
 * @author: bluces.wang
 *
 */
@Data
public class PagesNoTotalResult<T> extends BaseResult {

    @ApiModelProperty(value = "当前页码，从0开始")
    private Integer page;
    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;
    @ApiModelProperty(value = "返回数据 列表")
    private List<T> data;


    public PagesNoTotalResult<T> success(Integer page, Integer pageSize, List<T> data) {
        this.setPage(page);
        this.setPageSize(pageSize);
        this.setData(data);
        return this;
    }
}
