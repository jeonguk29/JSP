package iducs.javaweb.fundmentals201912047final.study;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet29_Cookie", value = "/Servlet29_Cookie")
public class Servlet29_Cookie extends HttpServlet {

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

            //int x = (Integer)application.getAttribute("value");
            //int x = (Integer)session.getAttribute("value");

            int x = 0;
            for(Cookie c : cookies){  // 내가 찾는 쿠키가 있는지 확인
                if(c.getName().equals("value")){
                    x = Integer.parseInt(c.getValue());
                    break; // 찾았으면 빠져나오기
                }
            }

            int y = v; // 현재 불러옴 값
            //String operator = (String)application.getAttribute("op"); // 연산자 불러옴
            //String operator = (String)session.getAttribute("op"); // 연산자 불러옴

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
            // map 컬렉션 사용한다고 생각하면 편함
//            application.setAttribute("value", v);
//            application.setAttribute("op", op);
//            session.setAttribute("value", v);
//            session.setAttribute("op", op);

            /*

            쿠키 특징
            쿠키는 사용자에게 심었다가
            가져올때 다시 아 맞다 쿠기를 심었었지 하고 배열 형태로 받게됨 몇개일지 모르니까
            쿠기는 심고 가져올때 무조건 문자열 형태여야함 나중에 Json 등을 배우면 다양한 형태로 저장이 가능함
            
             */
            Cookie valueCookie = new Cookie("value", String.valueOf(v));
            Cookie opCookie = new Cookie("op", op); // 쿠기 두개 저장

            // 클라이언트에게 전송
            res.addCookie(valueCookie);
            res.addCookie(opCookie);
            // 브라우저는 어? 쿠키왔네 하고 자기꺼 저장함


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
