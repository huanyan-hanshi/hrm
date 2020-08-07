package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class AdjustSalary {
    @TableId
    private Integer id;

    private Integer eid;

    private Date asdate;

    private Integer beforesalary;

    private Integer aftersalary;

    private String reason;

    private String remark;

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
