package com.sbs.jsp.board.servlet;

import com.sbs.jsp.board.Rq;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/gugudan")
public class gugudan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 인코딩
        Rq rq = new Rq(req,resp);
        int dan = rq.getIntParam("dan",9);
        int limit = rq.getIntParam("limit",9);
        // 소스작성
        // String rs = "<h1>%d단</h1>".formatted(dan); String 객체를 통해 작성할 경우 오히려 비효율적
        rq.writer("<h1>%d단</h1>".formatted(dan));
        for (int i = 1; i <= limit; i++) {
            //rs += "<div>%d * %d = %d</div>".formatted(dan, i, dan * i);
            //resp.getWriter().append("<div>%d * %d = %d</div>".formatted(dan, i, dan * i));
            rq.writer("<div>%d * %d = %d</div>".formatted(dan, i, dan * i));
        }
        rq.writer(""" 
<div class="a"></div>

<style>
    .a{
        width: 100px;
        height: 100px;
        background-color:red;
    }
</style>
                    """);
        //resp.getWriter().append(rs);
    }
}
