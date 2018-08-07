package cn.wolfcode.rbac.service.impl;

import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.mapper.RoleMapper;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IRoleService;
import cn.wolfcode.rbac.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService{
    @Autowired
    private RoleMapper mapper;

    public void saveOrUpdate(Role entity) {
        if (entity.getId() == null) {
            mapper.save(entity);
        }else {
            mapper.update(entity);
        }
    }

    public void delete(Long id) {
        mapper.delete(id);
    }

    public Role get(Long id) {
        return mapper.get(id);
    }

    public List<Role> list() {

        return mapper.list();
    }
    public PageResult query(QueryObject qo) {
        Integer totalCount = mapper.queryForCount(qo);
        if (totalCount == 0) {
            return PageResult.EMPTY_RESULT;
        }
        List<?> data = mapper.queryForList(qo);
        return new PageResult(qo.getCurrentPage(),qo.getPageSize(),totalCount,data);
    }
}
