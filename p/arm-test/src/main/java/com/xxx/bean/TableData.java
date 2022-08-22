package com.xxx.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName TableData
 * @Description
 * @Date 2022-08-13 9:54
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableData<T> implements Serializable {
    private String msg;      //消息  失败则显示msg内容
    private Integer code;    //标识码 0，成功   1.失败
    private List<T> data;    //内容
    private Long count;      //数据总条数
}
