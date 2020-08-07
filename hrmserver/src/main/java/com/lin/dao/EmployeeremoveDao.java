package com.lin.dao;

import com.lin.entity.Employeeremove;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeremoveDao {
    int insertSelective(Employeeremove record);

    int updateByPrimaryKeySelective(Employeeremove record);
}
