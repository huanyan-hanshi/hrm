package com.lin.dao;

import com.lin.entity.OpLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OpLogDao {
    int insertSelective(OpLog record);

    int updateByPrimaryKeySelective(OpLog record);
}
