package cn.wolfcode.rbac.web.controller;

import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IPermissionService;
import cn.wolfcode.rbac.util.PageResult;
import cn.wolfcode.rbac.util.RequiredPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    private IPermissionService service;

    @RequestMapping("reload")
    public ModelAndView reload(HttpServletResponse resp)throws Exception{
        service.reload();
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().print("{\"success\":true}");
        return null;
    }
    @RequiredPermission("权限列表")
    @RequestMapping("list")
    public String list(@ModelAttribute("qo") QueryObject qo, Model model){
        PageResult result = service.query(qo);
        model.addAttribute("result",result);
        return "permission/list";
    }
    @RequestMapping("delete")
    public String delete(Long id){
        if (id != null) {
            service.delete(id);
        }
        return "redirect:/permission/list.do";
    }
}
