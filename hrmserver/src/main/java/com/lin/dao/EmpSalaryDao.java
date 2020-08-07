package com.lin.dao;

import com.lin.entity.EmpSalary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpSalaryDao {
    int insert(EmpSalary record);

    int updateByPrimaryKeySelective(EmpSalary record);

}
