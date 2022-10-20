package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet33_Redirection", value = "/Servlet33_Redirection")
public class Servlet33_Redirection extends HttpServlet {

    // 세션사용시 HttpServletRequest 이렇게 해줘야함
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8"); // 값 보내줄대
        req.setCharacterEncoding("UTF-8");// 읽을때도 UTF 8로 읽어라 현제 CharacterEncoding 필터를 사용함
        PrintWriter out = res.getWriter();




        ServletContext application = req.getServletContext(); //  application 저장소에 저장 할거임 어플리케이션 전역 사용가능한
        HttpSession session = req.getSession(); // 세션에 저장 : 사용자 마다 다른 공간

        Cookie[] cookies = req.getCookies(); // 쿠키를 읽어옴 배열 형태로 받아야함


        String v_ = req.getParameter("v");
        String op = req.getParameter("operator");


        int v = 0;

        if(!v_.equals("")) v = Integer.parseInt(v_);

        if(op.equals("=")){



            int x = 0;
            for(Cookie c : cookies){  // 내가 찾는 쿠키가 있는지 확인
                if(c.getName().equals("value")){
                    x = Integer.parseInt(c.getValue());
                    break; // 찾았으면 빠져나오기
                }
            }

            int y = v; // 현재 불러옴 값


            String operator = "";
            
            for(Cookie c : cookies){  // 내가 찾는 쿠키가 있는지 확인
                if(c.getName().equals("op")){
                    operator = c.getValue();
                    break; // 찾았으면 빠져나오기
                }
            }

            int result = 0;

            if(operator.equals("+"))
                result = x + y;
            else
                result = x - y;

            res.getWriter().printf("result is %d\n", result);
        }
        else {

            /*

            현제 계산기는 클라이어느 사용자가 값 입력하고 뒤로가기 눌러서 반복하는 구조인데 이걸 서블릿이 대신
            ex calc.html 이쪽으로 경로를 우회해서 줄 수가 있음
            클라는 그러면 백지 보여지는게 아니라 다시 요청 한것 처럼 보임

            
             */
            Cookie valueCookie = new Cookie("value", String.valueOf(v));
            Cookie opCookie = new Cookie("op", op);

            valueCookie.setPath("/Servlet33_Redirection");
            valueCookie.setMaxAge(24 * 60 * 60);


            opCookie.setPath("/Servlet33_Redirection");


            res.addCookie(valueCookie);
            res.addCookie(opCookie);

            res.sendRedirect("/study/33Redirection.html");


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
