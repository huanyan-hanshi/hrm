package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class HrRole {
    @TableId
    private Integer id;

    private Integer hrid;

    private Integer rid;

}
