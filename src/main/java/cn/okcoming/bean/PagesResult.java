package cn.okcoming.bean;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: bluces.wang
 *
 */
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

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
