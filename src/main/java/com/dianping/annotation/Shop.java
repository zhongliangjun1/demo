package com.dianping.annotation;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-4-9
 * Time: PM7:35
 * To change this template use File | Settings | File Templates.
 */
public class Shop implements Serializable {
    private static final long serialVersionUID = -3479685883290051899L;

    private int shopId;
    private String shopName;
    private Date addTime;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
