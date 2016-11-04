package com.brendon.lee.vo;

import java.util.Date;

public class Mark {
    private int id;
    private int storeId;
    private String nickName;
    private int point;
    private Date registerDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Mark [id=" + id + ", storeId=" + storeId + ", nickName=" + nickName + ", point=" + point
                + ", registerDate=" + registerDate + "]";
    }
}