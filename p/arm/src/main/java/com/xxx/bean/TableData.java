package com.xxx.bean;

import java.util.List;

//创建一个与前端展示相关的实体类，属性与测试的data.jsp对应
public class TableData<T> {//写泛型T更加通用可以赋值Account类也可以赋值其他!
    private  String msg;  //消息  失败则显示msg内容
    private  Integer code;  //标识码 0，成功   1.失败
    private  List<T> data;   //内容
    private  Long   count;  //数据总条数

    public TableData() {
    }

    public TableData(String msg, Integer code, List<T> data, Long count) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TableData{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                ", count=" + count +
                '}';
    }
}