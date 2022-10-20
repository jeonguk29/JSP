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


@WebServlet(name = "Servlet35_2_Redirection_Servlet", value = "/Servlet35_2_Redirection_Servlet")
public class Servlet35_2_Redirection_Servlet extends HttpServlet {

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
        if(cookies != null){

            for(Cookie c : cookies){  // 내가 찾는 쿠키가 있는지 확인
                if(c.getName().equals("exp")){
                    exp = c.getValue();
                    break; // 찾았으면 빠져나오기
                }
            }

        }

        if(operator != null && operator.equals("=")){ // = 일때만 계산 해서 출력
                // 스크립트 라이브러리를 사용해서 꼼수로 처리 하겠음
            // https://zetawiki.com/wiki/Pom.xml,_build.gradle_%EB%B9%84%EA%B5%90 그레이들 메이븐 은 설정 다르게 해줘야함 nashorn 지원 x
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");// nashorn 엔진이름임

            try {
                exp =String.valueOf(engine.eval(exp)); // 오브젝트 객체 반환해서 스트링으로 바꿔 연산 결과 값을 넣어줌
                // (engine.eval(exp) : 쿠키에서 오는 연산식을 그대로 수행 할 수 있음
            } catch (ScriptException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            // 전달 온 무언가가 널이 아니면 계속 값을 문자열에 추가함
            exp += (value == null)? "":value;
            exp += (operator == null)? "":operator;
            exp += (dot == null)? "":dot;
        }



        Cookie expCookie = new Cookie("exp", exp);
        res.addCookie(expCookie);
        res.sendRedirect("/Servlet35_dinamic_page2");// 경로가 같아서 /Servlet35_dinamic_page2 앞에 / 없어도 됨







    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
