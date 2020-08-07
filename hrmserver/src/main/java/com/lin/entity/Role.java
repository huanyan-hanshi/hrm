package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {
    @TableId
    private Integer id;

    private String name;

    private String nameZh;
}
