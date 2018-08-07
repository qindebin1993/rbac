package cn.wolfcode.rbac.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseDomain{
    private String name;
    private String sn;
}
