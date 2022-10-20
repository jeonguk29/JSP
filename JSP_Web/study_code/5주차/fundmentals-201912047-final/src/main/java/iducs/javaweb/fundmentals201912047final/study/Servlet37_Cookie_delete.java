package iducs.javaweb.fundmentals201912047final.study;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet37_Cookie_delete", value = "/Servlet37_Cookie_delete")
public class Servlet37_Cookie_delete extends HttpServlet {

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


        // 사용자가 입력해서 넘어오는 벨류는 이 3개가 전부임
        String value = req.getParameter("value");
        String operator = req.getParameter("operator");
        String dot = req.getParameter("dot");


        String exp = "0";
        if(cookies != null){ // 쿠키를 지웠을때 빠져나가서 디폴트가 0 되니까 0이 출력 됨

            for(Cookie c : cookies){
                if(c.getName().equals("exp")){
                    exp = c.getValue();
                    break;
                }
            }

        }


        if(operator != null && operator.equals("=")){
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");// nashorn 엔진이름임

            try {
                exp =String.valueOf(engine.eval(exp));

            } catch (ScriptException e) {
                throw new RuntimeException(e);
            }
        }
         /*
        c 버튼을 누르면 쿠키를 지우도록 해보겠음 이렇게 하지 않으면 쿠키를 수동으로 지우던가
        사라질때 까지 기다려야함
         */
        else if(operator != null && operator.equals("C")) {
            exp = ""; // 쿠키를 사용하는 값을 비워 버리면 지워지는 것임
            // 아래서 설정 하나 더해줘야함
        }
        else{
            exp += (value == null)? "":value;
            exp += (operator == null)? "":operator;
            exp += (dot == null)? "":dot;
        }



        Cookie expCookie = new Cookie("exp", exp);
        if(operator != null && operator.equals("C"))
             expCookie.setMaxAge(0);// 이걸 설정 해줘야 쿠키 삭제가 바로 됨
        // 순서 빈값 주고 0으로 출력되게 하기 2 진짜 쿠키 지우기

        res.addCookie(expCookie);
        res.sendRedirect("/Servlet37_dinamic_page3");// 경로가 같아서 /Servlet35_dinamic_page2 앞에 / 없어도 됨







    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
