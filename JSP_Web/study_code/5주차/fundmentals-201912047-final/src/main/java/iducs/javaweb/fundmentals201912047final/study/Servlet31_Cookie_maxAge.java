package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet31_Cookie_maxAge", value = "/Servlet31_Cookie_maxAge")
public class Servlet31_Cookie_maxAge extends HttpServlet {

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

               쿠키 생명주기는 따로 설정하지 않으면 브라우저의 생명주기와 같아짐 브라우저 종료시 죽음
               쿠키의 가장큰 장점은 브라우저가 닫혀도 내가 원하는 기간을 설정하면 그 기간내에 값을 계속 유지하게 해주는 특징이 있음

            
             */
            Cookie valueCookie = new Cookie("value", String.valueOf(v));
            Cookie opCookie = new Cookie("op", op); // 쿠기 두개 저장

            valueCookie.setPath("/Servlet31_Cookie_maxAge");// 쿠기가 어느 경우에 사용자에게 전달 되어야 하는지 / 면 모든 페이지를 요청 할때마다 벨류 쿠기가져오라는 것임
            valueCookie.setMaxAge(24 * 60 * 60); // 만료 날짜 설정
            /*
            60만 주면 초
            60 * 60은 1시간
            24 * 60 * 60은 24시간
            이 쿠기를 보내면 하루동안은 이쿠키 살아 있어야함 브라우저가 닫히고 클라이언트 컴퓨터가 꺼졌다고 하더라도

            세션은 각 캐비넷 마다 데이터를 보관하고 세션이 시작되고 종료 될 때 까지가 생명 주기다.
            어플리케이션은 전역범위에서 사용하고 WAS가 시작해서 종료 될 때 까지가 생명 주기다

            생명 주기가 긴(1년) 데이터는 쿠키에 보관해야 한다.   : 세션에 저장 1년 못할 뿐더러 세션 종료 되면 다시 이 값 그 사용자가 가지질 못함
            특정 url로 전달되는 데이터는 쿠키에 보관해야 한다.   : 즉 다른 서블릿, 페이지에 영향 주지 않고 딱 여기서만 쓰는 데이터는 쿠키로 보내는게 좋음
            서버 부담을 줄여주기 때문에
             */

            opCookie.setPath("/Servlet31_Cookie_maxAge"); // 따로 종료 시간 값 없어서 브라우저 꺼지면 죽음



            // 클라이언트에게 전송
            res.addCookie(valueCookie);
            res.addCookie(opCookie);



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
