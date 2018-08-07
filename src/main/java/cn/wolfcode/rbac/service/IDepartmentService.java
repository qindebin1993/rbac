package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.util.PageResult;

import java.util.List;

/**
 * Created by Ben on 2018/3/29.
 */
public interface IDepartmentService {
    void saveOrUpdate(Department entity);
    void delete(Long id);
    Department get(Long id);
    List<Department> list();

    PageResult query(QueryObject qo);
}
