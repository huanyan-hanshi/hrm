package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class MsgContent {
    @TableId
    private Integer id;

    private String title;

    private String message;

    private Date createdate;

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}
