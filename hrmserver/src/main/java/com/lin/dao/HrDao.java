package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.lin.entity.Hr;
import com.lin.entity.Role;

import java.util.List;
@Mapper
public interface HrDao extends BaseMapper<Hr> {

    int updateByPrimaryKeySelective(Hr record);
    int insertSelective(Hr record);
    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("keywords") String keywords);

    Integer updatePasswd(@Param("hrid") Integer hrid, @Param("encodePass") String encodePass);

    Integer updateUserface(@Param("url") String url, @Param("id") Integer id);
}
