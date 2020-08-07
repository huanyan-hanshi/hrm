package com.lin.dao;

import com.lin.entity.AdjustSalary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdjustSalaryDao {
    int insertSelective(AdjustSalary record);

    int updateByPrimaryKeySelective(AdjustSalary record);
}
