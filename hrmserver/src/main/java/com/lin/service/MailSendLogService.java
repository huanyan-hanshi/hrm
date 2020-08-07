package com.lin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.dao.MailSendLogDao;
import com.lin.entity.MailSendLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MailSendLogService {
    @Autowired
    MailSendLogDao mailSendLogDao;
    public Integer updateMailSendLogStatus(String msgId, Integer status) {
        return mailSendLogDao.updateMailSendLogStatus(msgId, status);
    }

    public Integer insert(MailSendLog mailSendLog) {
        return mailSendLogDao.insert(mailSendLog);
    }

    public List<MailSendLog> getMailSendLogsByStatus() {
        return mailSendLogDao.getMailSendLogsByStatus();
    }

    public Integer updateCount(String msgId, Date date) {
        return mailSendLogDao.updateCount(msgId,date);
    }
}
