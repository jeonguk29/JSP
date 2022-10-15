package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet3_Get_QueryString_nullCheck", value = "/Servlet3_Get_QueryString_nullCheck")
public class Servlet3_Get_QueryString_nullCheck extends HttpServlet {

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");

        PrintWriter out = res.getWriter();
    
       /*
       url 에서 값 전달시 이렇게 옴
       /Servlet3_Get_QueryString_nullCheck?cnt=3    => "3"
       /Servlet3_Get_QueryString_nullCheck?cnt=     => ""
       /Servlet3_Get_QueryString_nullCheck?         => null
       /Servlet3_Get_QueryString_nullCheck          -> null 
        
        */
        
        String cnt_ =  req.getParameter("cnt"); // 임시 저장소 저장
        int cnt = 100;// 기본값 지정
        if(cnt_ != null && !cnt_.equals(""))// 빈문자열이라 널 값아닐때
            cnt = Integer.parseInt(cnt_); // 오는 문자열을 정수로 변환

        for(int i=0; i<cnt; i++)
        {
            out.println(i+"안녕 Servlet");
        }
        // 보통 사용자가 URL에 값 이런식으로 입력 안하고 페이지에서 사용함
        // study 폴더에 test.html 파일 a태그에 적용
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
