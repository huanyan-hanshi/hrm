package com.lin.dao;

import com.lin.entity.Employeetrain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeetrainDao {
    int insertSelective(Employeetrain record);

    int updateByPrimaryKeySelective(Employeetrain record);
}
