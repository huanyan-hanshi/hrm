package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.lin.entity.HrRole;
@Mapper
public interface HrRoleDao extends BaseMapper<HrRole> {
    int insertSelective(HrRole record);

    int updateByPrimaryKeySelective(HrRole record);

    Integer addRole(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);
}
