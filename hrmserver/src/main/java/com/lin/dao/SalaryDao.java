package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.entity.Salary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SalaryDao extends BaseMapper<Salary> {
    int insertSelective(Salary record);

    int updateByPrimaryKeySelective(Salary record);
}
