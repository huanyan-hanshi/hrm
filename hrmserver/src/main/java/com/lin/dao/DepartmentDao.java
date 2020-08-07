package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DepartmentDao extends BaseMapper<Department> {
    void addDep(Department dep);

    void deleteDepById(Department dep);

    int insertSelective(Department record);

    int updateByPrimaryKeySelective(Department record);
}
