package cn.wolfcode.rbac.web.controller;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.query.EmployeeQueryObject;
import cn.wolfcode.rbac.service.IDepartmentService;
import cn.wolfcode.rbac.service.IEmployeeService;
import cn.wolfcode.rbac.util.PageResult;
import cn.wolfcode.rbac.util.RequiredPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("list")
    public String list(@ModelAttribute("qo")EmployeeQueryObject qo, Model model){
        PageResult result = employeeService.query(qo);
        model.addAttribute("depts",departmentService.list());
        model.addAttribute("result",result);
        return "employee/list";
    }
    @RequiredPermission("编辑员工")
    @RequestMapping("input")
    public String input(Model model,Long id){
        model.addAttribute("depts",departmentService.list());
        if (id != null) {
            Employee entity = employeeService.get(id);

            model.addAttribute("entity",entity);
        }
        return "employee/input";
    }
    @RequiredPermission("更新/保存员工")
    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Employee entity){
        employeeService.saveOrUpdate(entity);
        return "redirect:/employee/list.do";
    }
    @RequestMapping("delete")
    public String delete(Long id){
        if (id != null) {
            employeeService.delete(id);
        }
        return "redirect:/employee/list.do";
    }
}
