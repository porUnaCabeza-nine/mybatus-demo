package com.demo.collercionsDemo;

/**
 * @description:
 * @author: ljc
 * @createDate: 2020-03-18 17:15
 */
public class SysMenu {

    private String name;
    /**
     * 排序字段
     */
    private Integer orderNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "name='" + name + '\'' +
                ", orderNum=" + orderNum +
                '}';
    }
}
