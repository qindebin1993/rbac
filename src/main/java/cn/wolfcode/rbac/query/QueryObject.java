package cn.wolfcode.rbac.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

/**
 * Created by Ben on 2018/3/29.
 */
@Getter
@Setter
public class QueryObject {
    private int currentPage = 1;
    private int pageSize = 3;

    protected String empty2Null(String s){

        return StringUtils.hasLength(s) ? s : null;
    }

    public int getStart(){
        return (currentPage - 1 ) * pageSize;
    }
}
