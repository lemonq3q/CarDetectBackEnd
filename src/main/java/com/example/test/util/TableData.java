package com.example.test.util;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableData {
    /** 总记录数 */
    private long total;

    /** 列表数据 */
    private List<?> rows;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String msg;

    public static TableData getTableData(List<?> data){
        TableData rspData = new TableData();
        rspData.setCode(200);
        rspData.setMsg("查询成功");
        rspData.setRows(data);
        rspData.setTotal(new PageInfo(data).getTotal());
        return rspData;
    }
}
