package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.entity.Employeeec;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeecDao extends BaseMapper<Employeeec> {
    int insertSelective(Employeeec record);

    int updateByPrimaryKeySelective(Employeeec record);
}
