package cn.wolfcode.rbac.mapper;

import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.query.QueryObject;

import java.util.List;

public interface RoleMapper {
    void save(Role entity);
    void update(Role entity);
    void delete(Long id);
    Role get(Long id);
    List<Role> list();

    List<?> queryForList(QueryObject qo);

    Integer queryForCount(QueryObject qo);
}
