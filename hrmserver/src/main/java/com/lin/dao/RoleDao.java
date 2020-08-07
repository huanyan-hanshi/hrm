package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleDao extends BaseMapper<Role> {
    int insertSelective(Role record);

    int updateByPrimaryKeySelective(Role record);
}
