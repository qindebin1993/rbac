package cn.wolfcode.rbac.util;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class PageResult {
    public static final PageResult EMPTY_RESULT =
            new PageResult(1,3,0,Collections.EMPTY_LIST);
    private int currentPage;
    private int pageSize;

    private int prevPage;
    private int nextPage;
    private int totalPage;

    private int totalCount;
    private List<?> list;

    public PageResult(int currentPage, int pageSize, int totalCount, List<?> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.list = list;

        if(totalCount <= pageSize){
            totalPage=1;
            prevPage=1;
            nextPage=1;
            return;
        }
        totalPage=totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        prevPage=currentPage - 1 > 0 ?  currentPage - 1 : 1;
        nextPage=currentPage + 1 > totalPage ? totalPage : currentPage + 1;
    }
}
