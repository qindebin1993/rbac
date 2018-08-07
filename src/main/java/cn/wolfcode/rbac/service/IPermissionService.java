package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Permission;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.util.PageResult;

import java.util.List;

public interface IPermissionService {
    void delete(Long id);
    List<Permission> list();

    PageResult query(QueryObject qo);

    void reload();
}
