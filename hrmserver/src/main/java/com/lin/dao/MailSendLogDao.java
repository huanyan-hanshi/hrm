package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.lin.entity.MailSendLog;

import java.util.Date;
import java.util.List;
@Mapper
public interface MailSendLogDao extends BaseMapper<MailSendLog> {
    Integer updateMailSendLogStatus(@Param("msgId") String msgId, @Param("status") Integer status);
    List<MailSendLog> getMailSendLogsByStatus();

    Integer updateCount(@Param("msgId") String msgId, @Param("date") Date date);
}
