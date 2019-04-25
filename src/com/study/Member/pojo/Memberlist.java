package com.study.Member.pojo;


import java.sql.Timestamp;
import java.util.Date;

public class Memberlist {

  private Integer mid;
  private String login_Name;
  private String real_Name;
  private String mpwd;
  private Timestamp reg_Time;
  private Integer score;
  private String header_Image;
  private String phone;
  private String sex;
  private Date birthday;


  public Integer getMid() {
    return mid;
  }

  public void setMid(Integer mid) {
    this.mid = mid;
  }

  public String getLogin_Name() {
    return login_Name;
  }

  public void setLogin_Name(String login_Name) {
    this.login_Name = login_Name;
  }

  public String getReal_Name() {
    return real_Name;
  }

  public void setReal_Name(String real_Name) {
    this.real_Name = real_Name;
  }

  public String getMpwd() {
    return mpwd;
  }

  public void setMpwd(String mpwd) {
    this.mpwd = mpwd;
  }

  public Timestamp getReg_Time() {
    return reg_Time;
  }

  public void setReg_Time(Timestamp reg_Time) {
    this.reg_Time = reg_Time;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  public String getHeader_Image() {
    return header_Image;
  }

  public void setHeader_Image(String header_Image) {
    this.header_Image = header_Image;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Memberlist(Integer mid, String login_Name, String real_Name, String mpwd, Timestamp reg_Time, Integer score, String header_Image, String phone, String sex, Date birthday) {
    this.mid = mid;
    this.login_Name = login_Name;
    this.real_Name = real_Name;
    this.mpwd = mpwd;
    this.reg_Time = reg_Time;
    this.score = score;
    this.header_Image = header_Image;
    this.phone = phone;
    this.sex = sex;
    this.birthday = birthday;
  }

  public Memberlist() {
  }

  @Override
  public String toString() {
    return "Memberlist{" +
            "mid=" + mid +
            ", login_Name='" + login_Name + '\'' +
            ", real_Name='" + real_Name + '\'' +
            ", mpwd='" + mpwd + '\'' +
            ", reg_Time=" + reg_Time +
            ", score=" + score +
            ", header_Image='" + header_Image + '\'' +
            ", phone='" + phone + '\'' +
            ", sex='" + sex + '\'' +
            ", birthday=" + birthday +
            '}';
  }
}
