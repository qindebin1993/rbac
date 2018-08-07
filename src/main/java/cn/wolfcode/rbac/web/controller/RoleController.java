package cn.wolfcode.rbac.web.controller;

import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IPermissionService;
import cn.wolfcode.rbac.service.IRoleService;
import cn.wolfcode.rbac.util.PageResult;
import cn.wolfcode.rbac.util.RequiredPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private IRoleService service;
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("list")
    public String list(@ModelAttribute("qo") QueryObject qo, Model model){
        PageResult result = service.query(qo);
        model.addAttribute("result",result);
        return "role/list";
    }
    @RequiredPermission("编辑角色")
    @RequestMapping("input")
    public String input(Model model,Long id){
        if (id != null) {
            Role entity = service.get(id);
            model.addAttribute("entity",entity);
        }
        model.addAttribute("permissions",permissionService.list());
        return "role/input";
    }
    @RequiredPermission("保存/更新角色")
    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Role entity){
        if (entity.getId() != null) {
            service.saveOrUpdate(entity);
        }else{
            service.saveOrUpdate(entity);
        }
        return "redirect:/role/list.do";
    }
    @RequestMapping("delete")
    public String delete(Long id){
        if (id != null) {
            service.delete(id);
        }
        return "redirect:/role/list.do";
    }
}
