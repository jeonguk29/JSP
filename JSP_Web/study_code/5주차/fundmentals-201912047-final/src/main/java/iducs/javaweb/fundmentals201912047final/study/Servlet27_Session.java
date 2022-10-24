package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet27_Session", value = "/Servlet27_Session")
public class Servlet27_Session extends HttpServlet {

    // 세션사용시 HttpServletRequest 이렇게 해줘야함
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8"); // 값 보내줄대
        req.setCharacterEncoding("UTF-8");// 읽을때도 UTF 8로 읽어라 현제 CharacterEncoding 필터를 사용함
        PrintWriter out = res.getWriter();


        /*
        어플리케이션 말고 Session을 이용해도 똑같음
        하지만 차이는 있는데 차이를 알아보자


        추가 자료 https://sgcomputer.tistory.com/m/239
        https://devlog-wjdrbs96.tistory.com/m/151
        https://dololak.tistory.com/m/553

        어플리케이션 객체는 어플리케이션 전역에서 사용가능함
        세션 객체는 세션 범주안에서 사용 할 수 있다는 뜻
        세션: 현제 접속한 사용자를 말함
        즉 사용자(세션) 별로 공간이 달라질수 있다.

        파이어 베이스 브라우저
        크롬 브라우저 연산하면 값이 다르지만 (다른 세션 인식)
        크롬 브라우저 여러개 띄우고 값 전달해보면 세션이 같다고 함
        이유는
        크롬 브라우저 여러개 띄어도
        여러 프로세스가 동작하느게 아니라 하나의 프로세스 안에 여러 스레드(탭 여러개)가 자원을 공유 하면서 동작하기 때문

        서버는 세션 id를 통해 사용자를 구분함
        브라우저 껏다 키면 세션아이디 다시 발급해서 줌
        +
        보안상 세션아이디가 같으면 같은 사용자로 인식하기 때문에
        세션관리에 대한 다양한 함수들을 지원함
        타임 아웃으로 설정하는 등 (기본은 30분임)


        쿠키는 값을 사용자가 가지고 다니는것임 (헬스장 지물건 지가 가지고 다님)


         */


        ServletContext application = req.getServletContext(); //  application 저장소에 저장 할거임 어플리케이션 전역 사용가능한
        HttpSession session = req.getSession(); // 세션에 저장 : 사용자 마다 다른 공간



        String v_ = req.getParameter("v");
        String op = req.getParameter("operator");


        int v = 0;

        if(!v_.equals("")) v = Integer.parseInt(v_);

        if(op.equals("=")){

            //int x = (Integer)application.getAttribute("value");
            int x = (Integer)session.getAttribute("value");
            // = 이면 이전거 저장된거 가져옴 반환시 오브젝트 객체라 형변환 해줌
            int y = v; // 현재 불러옴 값
            //String operator = (String)application.getAttribute("op"); // 연산자 불러옴
            String operator = (String)session.getAttribute("op"); // 연산자 불러옴

            int result = 0;

            if(operator.equals("+"))
                result = x + y;
            else
                result = x - y;

            res.getWriter().printf("result is %d\n", result);
        }
        else {
            // map 컬렉션 사용한다고 생각하면 편함
//            application.setAttribute("value", v);
//            application.setAttribute("op", op);
            session.setAttribute("value", v);
            session.setAttribute("op", op);
        }




        int result = 0;





    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
