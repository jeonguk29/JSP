package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet2_Get_QueryString", value = "/Servlet2_Get_QueryString")
public class Servlet2_Get_QueryString extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");

        PrintWriter out = res.getWriter();

        int cnt = Integer.parseInt(req.getParameter("cnt")); // 오는 문자열을 정수로 변환
        for(int i=0; i<cnt; i++)
        {
            out.println("안녕 Servlet");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
