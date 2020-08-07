package com.lin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.dao.PoliticsstatusDao;
import com.lin.entity.Politicsstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticsstatusService {
    @Autowired
    PoliticsstatusDao politicsstatusDao;
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusDao.selectList(new QueryWrapper<Politicsstatus>().select("*"));
    }
}
