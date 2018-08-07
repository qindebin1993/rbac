package cn.wolfcode.rbac.service.impl;
import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.mapper.EmployeeMapper;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IEmployeeService;
import cn.wolfcode.rbac.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private EmployeeMapper mapper;

    public void saveOrUpdate(Employee entity) {
        if (entity.getId() == null) {
            mapper.save(entity);
        }else {
            mapper.update(entity);
        }
    }

    public void delete(Long id) {
        mapper.delete(id);
    }

    public Employee get(Long id) {
        return mapper.get(id);
    }

    public List<Employee> list() {
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
