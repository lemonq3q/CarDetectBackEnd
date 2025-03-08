package com.example.test.util;


import com.github.pagehelper.PageHelper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {

    private static Integer pageSize;

    private static Integer pageNumber;

    public static boolean startPage(){
        getParams();
        if(pageSize != null && pageNumber != null){
            PageHelper.startPage(pageSize,pageNumber);
            return true;
        }
        return false;
    }

    private static void getParams(){
        pageSize = null;
        pageNumber = null;
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            try {
                pageSize = Integer.valueOf(request.getParameter("pageSize"));
                pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
            }catch (Exception e){
                pageSize = null;
                pageNumber = null;
            }
        }
    }
}
