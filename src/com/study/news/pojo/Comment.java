package com.study.news.pojo;

public class Comment {
    private Integer cid;
    private String ccontent;
    private Integer newid;

    public Comment(Integer cid, String ccontent, Integer newid) {
        this.cid = cid;
        this.ccontent = ccontent;
        this.newid = newid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public Integer getNewid() {
        return newid;
    }

    public void setNewid(Integer newid) {
        this.newid = newid;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", ccontent='" + ccontent + '\'' +
                ", newid=" + newid +
                '}';
    }
    public Comment() {
    }
}
