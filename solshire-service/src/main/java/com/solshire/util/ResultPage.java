package com.solshire.util;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author koabs
 * @Date 2018/5/30.
 * @Describe
 */
@Getter
@Setter
public class ResultPage<T> extends ResultBase{

    private List<T> data;

    private Paginator paginator;

    @ApiModelProperty("合计")
    private T total;

    public ResultPage<T> success(List<T> list) {
        super.success();
        this.data = list;
        return this;
    }

    public static <T> ResultPage<T> instance(Class<T> iclazz) {
        return new ResultPage<>();
    }

    //
    public ResultPage<T> success(PageInfo<T> pageInfo) {
        super.success();
        this.data = pageInfo.getList();
        this.paginator = new Paginator(pageInfo);
        return this;
    }

    public ResultPage<T> success(PageInfo<T> pageInfo, T total) {
        super.success();
        this.data = pageInfo.getList();
        this.paginator = new Paginator(pageInfo);
        this.total =  total;
        return this;
    }

    @Getter
    @Setter
    class Paginator {
        @ApiModelProperty("页码")
        private int pageNum;
        @ApiModelProperty("每页大小")
        private int pageSize;
        @ApiModelProperty("总记录")
        private long total;
        @ApiModelProperty("总页数")
        private int pages;

        public Paginator(PageInfo pageInfo) {
            this.pageNum = pageInfo.getPageNum();
            this.pageSize = pageInfo.getPageSize();
            this.total = pageInfo.getTotal();
            this.pages = pageInfo.getPages();
        }
    }

}
