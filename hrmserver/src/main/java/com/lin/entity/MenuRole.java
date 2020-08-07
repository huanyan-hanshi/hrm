package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class MenuRole {
    @TableId
    private Integer id;

    private Integer mid;

    private Integer rid;
}
