package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class EmpSalary {
    @TableId
    private Integer id;

    private Integer eid;

    private Integer sid;

}
