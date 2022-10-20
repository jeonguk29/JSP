package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet30_Cookie_path", value = "/Servlet30_Cookie_path")
public class Servlet30_Cookie_path extends HttpServlet {

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

            쿠키 설정시 URL 설정가능 이름 충돌 무분별 하게 사용 하는것을 방지하기 위해
            ex 나한테 전송 될때만 가져오고 보내라
            
             */
            Cookie valueCookie = new Cookie("value", String.valueOf(v));
            Cookie opCookie = new Cookie("op", op); // 쿠기 두개 저장

            valueCookie.setPath("/Servlet30_Cookie_path");// 쿠기가 어느 경우에 사용자에게 전달 되어야 하는지 / 면 모든 페이지를 요청 할때마다 벨류 쿠기가져오라는 것임
            opCookie.setPath("/Servlet30_Cookie_path");

            /*
             /Servlet30_Cookie_path  우리 경로에서만 사용할거면 이렇게 매 핑 해주는게 좋고
             /add 로 하면 우리 쪽으로 쿠키 안옴 /add 가 포함된 쪽으로 쿠기 가는거임
             / 하면 전체로 가고 : 전체에서 사용할때는 좋음
             /notice/ : 이런식으로 특정 경로 디렉토리 지정 가능함



                    */

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
