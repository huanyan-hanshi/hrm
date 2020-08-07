package com.lin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.dao.RoleDao;
import com.lin.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;
    public List<Role> getAllRoles() {
        return roleDao.selectList(new QueryWrapper<Role>().select("*"));
    }

    public Integer addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        return roleDao.insert(role);
    }

    public Integer deleteRoleById(Integer rid) {
        return roleDao.deleteById(rid);
    }
}
