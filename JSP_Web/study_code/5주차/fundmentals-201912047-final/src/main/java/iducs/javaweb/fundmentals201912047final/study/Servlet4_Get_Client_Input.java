package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet4_Get_Client_Input", value = "/Servlet4_Get_Client_Input")
public class Servlet4_Get_Client_Input extends HttpServlet {
    // study 폴더에 test.html에서 고정으로 값 전달 했는데
    // 사용자 입력데 따른 동적 get 요청 처리를 해보겠음
    // hello.html 확인
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");

        PrintWriter out = res.getWriter();



        String cnt_ =  req.getParameter("cnt"); // 임시 저장소 저장
        int cnt = 100;// 기본값 지정
        if(cnt_ != null && !cnt_.equals(""))// 빈문자열이라 널 값아닐때
            cnt = Integer.parseInt(cnt_); // 오는 문자열을 정수로 변환

        for(int i=0; i<cnt; i++)
        {
            out.println(i+"안녕 Servlet");
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
