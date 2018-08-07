package cn.wolfcode.rbac.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ben on 2018/3/31.
 */
@Getter@Setter
public class Permission extends BaseDomain {
    private String name;
    private String expression;
}
