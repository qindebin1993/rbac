package cn.wolfcode.rbac.service.impl;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.mapper.DepartmentMapper;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IDepartmentService;
import cn.wolfcode.rbac.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService{
    @Autowired
    private DepartmentMapper mapper;

    public void saveOrUpdate(Department entity) {
        if (entity.getId() == null) {
            mapper.save(entity);
        }else {
            mapper.update(entity);
        }
    }

    public void delete(Long id) {
        mapper.delete(id);
    }

    public Department get(Long id) {
        return mapper.get(id);
    }

    public List<Department> list() {

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
