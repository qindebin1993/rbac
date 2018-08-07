package cn.wolfcode.rbac.mapper;

import cn.wolfcode.rbac.domain.Permission;
import cn.wolfcode.rbac.query.QueryObject;

import java.util.List;

public interface PermissionMapper {
    void save(Permission entity);
    void delete(Long id);

    List<Permission> list();

    List<?> queryForList(QueryObject qo);
    Integer queryForCount(QueryObject qo);

    List<String> selectAllExpressions();

}
