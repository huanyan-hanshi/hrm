package com.lin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Department implements Serializable {
    @TableId
    private Integer id;

    private String name;

    private Integer parentId;

    public Department() {
    }

    public Department(String name) {

        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private String depPath;

    private Boolean enabled;

    private Boolean isParent;
    private List<Department> children = new ArrayList<>();
    private Integer result;
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
