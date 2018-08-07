package cn.wolfcode.rbac.mapper;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.query.QueryObject;

import java.util.List;

public interface EmployeeMapper {
    void save(Employee entity);
    void update(Employee entity);
    void delete(Long id);
    Employee get(Long id);
    List<Employee> list();

    List<?> queryForList(QueryObject qo);

    Integer queryForCount(QueryObject qo);
}
