package cn.wolfcode.rbac.mapper;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.query.QueryObject;

import java.util.List;

public interface DepartmentMapper {
    void save(Department entity);
    void update(Department entity);
    void delete(Long id);
    Department get(Long id);
    List<Department> list();

    List<?> queryForList(QueryObject qo);

    Integer queryForCount(QueryObject qo);
}
