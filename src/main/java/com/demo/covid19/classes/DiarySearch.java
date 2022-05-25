package com.demo.covid19.classes;

import java.sql.Date;

public class DiarySearch {

    Date date;
    String province;
    String content;

    public DiarySearch(Date date, String province, String content) {

        this.date = date;
        this.province = province;
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public String getProvince() {
        return province;
    }

    public String getContent() {
        return content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
