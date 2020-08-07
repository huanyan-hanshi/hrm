package com.lin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.dao.NationDao;
import com.lin.entity.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NationService {
    @Autowired
    NationDao nationDao;
    public List<Nation> getAllNations() {
        return nationDao.selectList(new QueryWrapper<Nation>().select("*"));
    }
}
