package com.study.vipManagement.beans;

import java.sql.Date;

public class Users {
    private Integer meid;
    private String head;
    private String nickname;
    private String realname;
    private String sex;
    private Date birth;
    private String constellation;
    private String provice;
    private String city;
    private String district;

    public Integer getMeid() {
        return meid;
    }

    public void setMeid(Integer meid) {
        this.meid = meid;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Users(Integer meid, String head, String nickname, String realname, String sex, Date birth, String constellation, String provice, String city, String district) {
        this.meid = meid;
        this.head = head;
        this.nickname = nickname;
        this.realname = realname;
        this.sex = sex;
        this.birth = birth;
        this.constellation = constellation;
        this.provice = provice;
        this.city = city;
        this.district = district;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "meid=" + meid +
                ", head='" + head + '\'' +
                ", nickname='" + nickname + '\'' +
                ", realname='" + realname + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", constellation='" + constellation + '\'' +
                ", provice='" + provice + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
