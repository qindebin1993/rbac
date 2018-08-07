package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.util.PageResult;

import java.util.List;

/**
 * Created by Ben on 2018/3/29.
 */
public interface IRoleService {
    void saveOrUpdate(Role entity);
    void delete(Long id);
    Role get(Long id);
    List<Role> list();

    PageResult query(QueryObject qo);
}
