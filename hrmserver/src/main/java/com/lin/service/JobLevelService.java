package com.lin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.dao.JobLevelDao;
import com.lin.entity.JobLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobLevelService {
    @Autowired
    JobLevelDao jobLevelDao;
    public List<JobLevel> getAllJobLevels() {
        return jobLevelDao.selectList(new QueryWrapper<JobLevel>().select("*"));
    }

    public Integer addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelDao.insertSelective(jobLevel);
    }

    public Integer updateJobLevelById(JobLevel jobLevel) {
        return jobLevelDao.updateByPrimaryKeySelective(jobLevel);
    }

    public Integer deleteJobLevelById(Integer id) {
        return jobLevelDao.deleteById(id);
    }

    public Integer deleteJobLevelsByIds(Integer[] ids) {
        return jobLevelDao.deleteJobLevelsByIds(ids);
    }

}
