package cn.wolfcode.rbac.web.controller;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IDepartmentService;
import cn.wolfcode.rbac.util.PageResult;
import cn.wolfcode.rbac.util.RequiredPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @RequestMapping("list")
    public String list(@ModelAttribute("qo") QueryObject qo, Model model){
        PageResult result = service.query(qo);
        model.addAttribute("result",result);
        return "department/list";
    }
    @RequiredPermission("编辑部门")
    @RequestMapping("input")
    public String input(Model model,Long id){
        if (id != null) {
            Department entity = service.get(id);
            model.addAttribute("entity",entity);
        }
        return "department/input";
    }
    @RequiredPermission("保存/更新部门")
    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Department entity){
        if (entity.getId() != null) {
            service.saveOrUpdate(entity);
        }else{
            service.saveOrUpdate(entity);
        }
        return "redirect:/department/list.do";
    }
    @RequestMapping("delete")
    public String delete(Long id){
        if (id != null) {
            service.delete(id);
        }
        return "redirect:/department/list.do";
    }
}
