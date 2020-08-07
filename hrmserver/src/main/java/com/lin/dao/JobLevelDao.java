package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.lin.entity.JobLevel;

import java.util.List;
@Mapper
public interface JobLevelDao extends BaseMapper<JobLevel> {
    int insertSelective(JobLevel record);

    int updateByPrimaryKeySelective(JobLevel record);
    Integer deleteJobLevelsByIds(@Param("ids") Integer[] ids);
}
