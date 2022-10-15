package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet5_Post", value = "/Servlet5_Post")
public class Servlet5_Post extends HttpServlet {
    // 여러값을 처리할떄는 Post 방식 사용

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");// 읽을때도 UTF 8로 읽어라 현제 CharacterEncoding 필터를 사용함
        PrintWriter out = res.getWriter();



        String title =  req.getParameter("title"); // 임시 저장소 저장
        String content =  req.getParameter("content"); // 임시 저장소 저장
        // 이렇게 받은 값을 데이터 베이스를 사용한다면 저장하고 처리 할 수 있을것임

        out.println(title);
        out.println(content);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
