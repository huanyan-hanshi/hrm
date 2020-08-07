package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysMsg {
    @TableId
    private Integer id;

    private Integer mid;

    private Integer type;

    private Integer hrid;

    private Integer state;
}
