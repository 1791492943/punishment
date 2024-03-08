package com.punishment.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PageQuery {
    /**
     * 当前页
     */
    private Integer pageNum;
    /**
     * 每页显示的条数
     */
    private Integer pageSize;

    /**
     * 默认页码
     */
    private static final Integer DEFAULT_PAGE_NUM = 1;

    /**
     * 默认每页显示的条数
     */
    private static final Integer DEFAULT_PAGE_SIZE = Integer.MAX_VALUE;

    public <T> Page<T> build(){
        int pageNum = this.pageNum == null ? DEFAULT_PAGE_NUM : this.pageNum;
        int pageSize = this.pageSize == null ? DEFAULT_PAGE_SIZE : this.pageSize;
        return new Page<>(pageNum, pageSize);
    }
}
