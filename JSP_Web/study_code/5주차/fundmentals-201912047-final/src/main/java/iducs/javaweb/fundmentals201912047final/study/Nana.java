package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Nana", value = "/Nana")// 어노테이션을 이용한 URL 매핑
public class Nana extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        // 리퀘스트(입력) 객체와 리스폰스(출력) 객체

        // 기본 웹페이지 입출력
        PrintWriter out = res.getWriter();
        out.println("hello ~~ adsf");

        //---------------------------------------

        // 웹 브라우저 컨텐츠 형식에 따라 아래 출력이 다르게 인식됨 자동으로 내려가서 출력되거나
        // 아니면 따로 <br> 태그를 넣어주거나
        // 기본은 ISO-8859-1 로 인코딩 해서 한글 깨짐
  
        // UTF-8로 인코딩을 해줘야함
        // +사용자에게 이문서는 HTML이고 UTF8로 읽으라고 셋팅
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");
        // 프로젝트 셋팅 ->에디터-> 파일인코딩 옵션 둘다 UTF로 맞춰주면 됨
        // 인텔리제이는 -Duser.language=en -Duser.region=en 톰켓 VM 옵션값에 넣어주면 됨
        for(int i=0; i < 100; i++)
        {
            out.println((i+1)+": 안녕 Hello Servlet!! <br/>");

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
