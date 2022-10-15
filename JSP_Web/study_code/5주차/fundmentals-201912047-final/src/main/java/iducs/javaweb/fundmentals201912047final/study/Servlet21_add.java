package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet21_add", value = "/Servlet21_add")
public class Servlet21_add extends HttpServlet {


    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8"); // 값 보내줄대
        req.setCharacterEncoding("UTF-8");// 읽을때도 UTF 8로 읽어라 현제 CharacterEncoding 필터를 사용함
        PrintWriter out = res.getWriter();



        String x_ = req.getParameter("x"); //
        String y_ =  req.getParameter("y"); //

        int x = 0;
        int y = 0;

        if(!x_.equals("")) x = Integer.parseInt(x_);
        if(!y_.equals("")) x = Integer.parseInt(y_);

        int result = x + y;
        res.getWriter().printf("result is %d\n", result);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
