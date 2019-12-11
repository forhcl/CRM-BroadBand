package com.boot.crm.broadband.dto;

/**
 * 前端跑过来说不能传不了[1,2]格式的数组给我，非要{"ids":[1,2,null]}格式的对象数组
 * @author Hogan_Lee
 * @create 2019-12-05 14:15
 */
public class ArrayObject {
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
