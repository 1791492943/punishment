package com.punishment.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * 表格分页数据对象
 */
@Data
@NoArgsConstructor
public class TableData<T> {

    /**
     * 总记录数
     */
    private long total;

    /**
     * 列表数据
     */
    private List<T> rows;

    /**
     * 消息状态码
     */
    private int code;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
    public TableData(List<T> list, long total) {
        this.rows = list;
        this.total = total;
    }

    public static <T> TableData<T> build(IPage<T> page) {
        TableData<T> rspData = new TableData<>();
        rspData.setCode(200);
        rspData.setMsg("查询成功");
        rspData.setRows(page.getRecords());
        rspData.setTotal(page.getTotal());
        return rspData;
    }

    public static <T> TableData<T> build(List<T> list) {
        TableData<T> rspData = new TableData<>();
        rspData.setCode(200);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(list.size());
        return rspData;
    }

    public static <T> TableData<T> build() {
        TableData<T> rspData = new TableData<>();
        rspData.setCode(200);
        rspData.setMsg("查询成功");
        return rspData;
    }

}
