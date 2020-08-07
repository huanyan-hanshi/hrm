package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.entity.Politicsstatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PoliticsstatusDao extends BaseMapper<Politicsstatus> {
    int insertSelective(Politicsstatus record);

    int updateByPrimaryKeySelective(Politicsstatus record);
}
