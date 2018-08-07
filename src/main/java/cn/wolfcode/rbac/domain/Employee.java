package cn.wolfcode.rbac.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Ben on 2018/3/29.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseDomain{
    private String name;
    private String password;
    private String email;
    private Integer age;
    private Boolean admin;
    private Integer dept_id;

    private Department dept;
}
