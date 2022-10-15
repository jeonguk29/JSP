package iducs.javaweb.fundmentals201912047final;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletContextTester", urlPatterns = "/ServletContextTester")// 이 유알엘 패턴이 가장 중요
public class ServletContextTester extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletContext sc = getServletContext();
        String driverName = sc.getInitParameter("driver-name");
        out.println("driver name is="+driverName+"<br/>");
        out.println("name ="+request.getParameter("name")+"<br/>");
//http://localhost:8080/ServletContextTester?name=woogie
        // 매개변수 가져올때 사용
        out.println("queryString = "+request.getQueryString());

        // 결과
        //name =woogie
        //queryString = name=woogie
        out.close();
    }
}
