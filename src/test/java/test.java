import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Ben on 2018/3/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {
    @Autowired
    private IDepartmentService service;
    @Test
    public void save(){
        //service.saveOrUpdate(new Department(1L,"销售部","sale"));
    }
    @Test
    public void delete(){
        service.delete(1L);
    }
    @Test
    public void get(){
        System.out.println(service.get(1L));
    }
    @Test
    public void list(){
        List<Department> list = service.list();
        for (Department d : list) {
            System.out.println(d);
        }
    }
}
