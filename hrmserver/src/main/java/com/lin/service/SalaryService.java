package com.lin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.dao.SalaryDao;
import com.lin.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalaryService {
    @Autowired
    SalaryDao salaryDao;

    public List<Salary> getAllSalaries() {
        return salaryDao.selectList(new QueryWrapper<Salary>().select("id, basicSalary, bonus, lunchSalary, trafficSalary, allSalary, pensionBase, pensionPer, createDate, medicalBase, medicalPer, accumulationFundBase, accumulationFundPer, name"));
    }

    public Integer addSalary(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryDao.insertSelective(salary);
    }

    public Integer deleteSalaryById(Integer id) {
        return salaryDao.deleteById(id);
    }

    public Integer updateSalaryById(Salary salary) {
        return salaryDao.updateByPrimaryKeySelective(salary);
    }
}
