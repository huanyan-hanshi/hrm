package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Employeeec {
    @TableId
    private Integer id;

    private Integer eid;

    private Date ecdate;

    private String ecreason;

    private Integer ecpoint;

    private Integer ectype;

    private String remark;

    public void setEcreason(String ecreason) {
        this.ecreason = ecreason == null ? null : ecreason.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
