package com.lin.dao;

import com.lin.entity.MsgContent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MsgContentDao {
    int insertSelective(MsgContent record);

    int updateByPrimaryKeySelective(MsgContent record);
}
