package com.lin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.dao.DepartmentDao;
import com.lin.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;
    public List<Department> getAllDepartments() {
        return departmentDao.selectList(new QueryWrapper<Department>().select("*").eq("parentId",-1));
    }

    public void addDep(Department dep) {
        dep.setEnabled(true);
        departmentDao.addDep(dep);
    }

    public void deleteDepById(Department dep) {
        departmentDao.deleteDepById(dep);
    }

    public List<Department> getAllDepartmentsWithOutChildren() {
        return departmentDao.selectList(new QueryWrapper<Department>().select("id, name, parentId, depPath, enabled, isParent"));
    }
}

