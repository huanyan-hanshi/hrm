package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Appraise {
    @TableId
    private Integer id;

    private Integer eid;

    private Date appdate;

    private String appresult;

    private String appcontent;

    private String remark;

    public void setAppresult(String appresult) {
        this.appresult = appresult == null ? null : appresult.trim();
    }

    public void setAppcontent(String appcontent) {
        this.appcontent = appcontent == null ? null : appcontent.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
