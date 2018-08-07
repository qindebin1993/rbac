package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.util.PageResult;

import java.util.List;

/**
 * Created by Ben on 2018/3/29.
 */
public interface IEmployeeService {
    void saveOrUpdate(Employee entity);
    void delete(Long id);
    Employee get(Long id);
    List<Employee> list();

    PageResult query(QueryObject qo);
}

