package com.example.summerad;

import java.io.Serializable;

import lombok.Data;


public class PubNotice {
    private Integer pubNoticeId;

    private String pubNoticeContent;

    private String pubNoticeTextcolor;

    private Integer pubNoticeTextsize;

    private String pubNoticeBgcolor;

    public Integer getPubNoticeId() {
        return pubNoticeId;
    }

    public void setPubNoticeId(Integer pubNoticeId) {
        this.pubNoticeId = pubNoticeId;
    }

    public String getPubNoticeContent() {
        return pubNoticeContent;
    }

    public void setPubNoticeContent(String pubNoticeContent) {
        this.pubNoticeContent = pubNoticeContent;
    }

    public String getPubNoticeTextcolor() {
        return pubNoticeTextcolor;
    }

    public void setPubNoticeTextcolor(String pubNoticeTextcolor) {
        this.pubNoticeTextcolor = pubNoticeTextcolor;
    }

    public Integer getPubNoticeTextsize() {
        return pubNoticeTextsize;
    }

    public void setPubNoticeTextsize(Integer pubNoticeTextsize) {
        this.pubNoticeTextsize = pubNoticeTextsize;
    }

    public String getPubNoticeBgcolor() {
        return pubNoticeBgcolor;
    }

    public void setPubNoticeBgcolor(String pubNoticeBgcolor) {
        this.pubNoticeBgcolor = pubNoticeBgcolor;
    }

    public Integer getPubNoticeBghigh() {
        return pubNoticeBghigh;
    }

    public void setPubNoticeBghigh(Integer pubNoticeBghigh) {
        this.pubNoticeBghigh = pubNoticeBghigh;
    }

    public String getPubNoticeTexthigh() {
        return pubNoticeTexthigh;
    }

    public void setPubNoticeTexthigh(String pubNoticeTexthigh) {
        this.pubNoticeTexthigh = pubNoticeTexthigh;
    }

    public String getPubNoticePlayspeed() {
        return pubNoticePlayspeed;
    }

    public void setPubNoticePlayspeed(String pubNoticePlayspeed) {
        this.pubNoticePlayspeed = pubNoticePlayspeed;
    }

    private Integer pubNoticeBghigh;

    private String pubNoticeTexthigh;

    private String pubNoticePlayspeed;

    public PubNotice() {
    }

//    public PubNotice(Integer pubNoticeId, String pubNoticeContent, String pubNoticeTextcolor, Integer pubNoticeTextsize, String pubNoticeBgcolor, Integer pubNoticeBghigh, String pubNoticeTexthigh, String pubNoticePlayspeed) {
//        this.pubNoticeId = pubNoticeId;
//        this.pubNoticeContent = pubNoticeContent;
//        this.pubNoticeTextcolor = pubNoticeTextcolor;
//        this.pubNoticeTextsize = pubNoticeTextsize;
//        this.pubNoticeBgcolor = pubNoticeBgcolor;
//        this.pubNoticeBghigh = pubNoticeBghigh;
//        this.pubNoticeTexthigh = pubNoticeTexthigh;
//        this.pubNoticePlayspeed = pubNoticePlayspeed;
//    }
}
