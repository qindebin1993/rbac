package cn.wolfcode.rbac.util;

import java.lang.reflect.Method;

public abstract class PermissionUtil {
    public static String BuildExpression(Method m){
        String className = m.getDeclaringClass().getName();
        return className+":"+m.getName();
    }
}
