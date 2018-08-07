package cn.wolfcode.rbac.service.impl;

import cn.wolfcode.rbac.domain.Permission;
import cn.wolfcode.rbac.mapper.PermissionMapper;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IPermissionService;
import cn.wolfcode.rbac.util.PageResult;
import cn.wolfcode.rbac.util.PermissionUtil;
import cn.wolfcode.rbac.util.RequiredPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService{
    @Autowired
    private PermissionMapper mapper;
    @Autowired
    private ApplicationContext cxt;

    //加载权限的业务方法
    public void reload() {
        List<String> exps = mapper.selectAllExpressions();
        //查询系统中已经拥有的权限表达式
        Collection<Object> ctrls = cxt.getBeansWithAnnotation(Controller.class).values();
        //从容器中获取到所有的控制器
        for (Object ctrl : ctrls) {
            //迭代每一个控制器的每一个方法
            Method[] ms = ctrl.getClass().getDeclaredMethods();
            for (Method m : ms) {
                String exp = PermissionUtil.BuildExpression(m);
                RequiredPermission anno = m.getAnnotation(RequiredPermission.class);
                //判断该方法是否有权限注解
                if (anno != null && !exps.contains(exp)) {
                    //生成一个权限对象
                    Permission p = new Permission();
                    //设置权限名称
                    p.setName(anno.value());
                    //设置权限表达式
                    p.setExpression(exp);
                    mapper.save(p);
                }
            }
        }
    }

    public void delete(Long id) {
        mapper.delete(id);
    }

    public List<Permission> list() {
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
