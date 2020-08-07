package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class OpLog {
    @TableId
    private Integer id;

    private Date adddate;

    private String operate;

    private Integer hrid;

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }
}
