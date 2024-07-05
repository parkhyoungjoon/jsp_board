package com.sbs.jsp.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;
    public Rq(HttpServletRequest req, HttpServletResponse resp) {
        this.req=req;
        this.resp=resp;

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
    }
    public int getIntParam(String paraName,int defaultValue){
        String val=req.getParameter(paraName);

        if(val==null){
            return defaultValue;
        }
        try {
            return Integer.parseInt(val);
        }catch (UnsupportedOperationException e){
            return defaultValue;
        }
    }
    public String getParam(String paraName,String defaultValue){
        String val=req.getParameter(paraName);

        if(val==null){
            return defaultValue;
        }
        return val;
    }
    public void writer(String str){
        try {
            resp.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
