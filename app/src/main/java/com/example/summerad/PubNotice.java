package com.example.summerad;

import java.io.Serializable;

import lombok.Data;

@Data
public class PubNotice implements Serializable {
    private Integer pubNoticeId;

    private String pubNoticeContent;

    private String pubNoticeTextcolor;

    private Integer pubNoticeTextsize;

    private String pubNoticeBgcolor;

    private Integer pubNoticeBghigh;

    private String pubNoticeTexthigh;

    private String pubNoticePlayspeed;

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
