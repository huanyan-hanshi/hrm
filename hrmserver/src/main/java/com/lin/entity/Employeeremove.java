package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Employeeremove {
    @TableId
    private Integer id;

    private Integer eid;

    private Integer afterdepid;

    private Integer afterjobid;

    private Date removedate;

    private String reason;

    private String remark;
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
