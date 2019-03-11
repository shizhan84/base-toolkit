package cn.okcoming.basebean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: bluces.wang
 *
 */
@Data
public class PagesResult<T> extends BaseResult {

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;
    @ApiModelProperty(value = "当前页码，从0开始")
    private Integer page;
    @ApiModelProperty(value = "总数量")
    private Integer totalCount;
    @ApiModelProperty(value = "是否有下一页")
    private boolean hasNext;
    @ApiModelProperty(value = "返回数据 列表")
    private List<T> data;

    public PagesResult<T> success(Integer page, Integer pageSize, Integer totalCount, List<T> data) {
        this.setPage(page);
        this.setPageSize(pageSize);
        this.setTotalCount(totalCount);
        this.setData(data);

        int totalPage = new BigDecimal(totalCount).divide(new BigDecimal(pageSize), 0, BigDecimal.ROUND_UP).intValue();
        if (totalPage > page + 1) {
            this.setHasNext(true);
        }
        return this;
    }

}
