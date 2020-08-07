package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Employeetrain {
    @TableId
    private Integer id;

    private Integer eid;

    private Date traindate;

    private String traincontent;

    private String remark;

    public void setTraincontent(String traincontent) {
        this.traincontent = traincontent == null ? null : traincontent.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
