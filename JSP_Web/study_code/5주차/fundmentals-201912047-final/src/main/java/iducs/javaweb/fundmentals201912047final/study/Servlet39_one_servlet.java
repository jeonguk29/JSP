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

@WebServlet(name = "Servlet39_one_servlet", value = "/Servlet39_one_servlet")
public class Servlet39_one_servlet extends HttpServlet {

  /*
  이전까지 작업 했던것을 하나의 서블릿으로 합처 보겠음


   */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8"); // 값 보내줄대
        req.setCharacterEncoding("UTF-8");// 읽을때도 UTF 8로 읽어라 현제 CharacterEncoding 필터를 사용함




        Cookie[] cookies = req.getCookies(); // 쿠키를 읽어옴 배열 형태로 받아야함
        String exp = "0";
        if(cookies != null){

            for(Cookie c : cookies){  // 내가 찾는 쿠키가 있는지 확인
                if(c.getName().equals("exp")){
                    exp = c.getValue(); // 안에 사용자가 입력한 문자가 저장된 exp 를 가져와서 넣어주고 아래서 출력해줌
                    break; // 찾았으면 빠져나오기
                }
            }

        }



        PrintWriter out = res.getWriter();


        out.write("<!DOCTYPE html>");
        out.write("<html lang=\"en\">");
        out.write("<head>");
        out.write(" <meta charset=\"UTF-8\">");
        out.write("<title>Title</title>");

        out.write("<style>");
        out.write("          input{");
        out.write("      width: 50px;");
        out.write("   height: 50px;");
        out.write(" }");
        out.write(".output{");
        out.write("    height: 50px;");
        out.write("    background: #e9e9e9;");
        out.write("    font-size: 24px;");
        out.write("    font-weight: bold;");
        out.write("    text-align: right;");
        out.write("    padding: 0px 5px;");
        out.write("}");
        out.write(" </style>");

        out.write("</head>");
        out.write("<body>");
        out.write("<form  method=\"post\">"); // 이렇게 하면 여기 따로 url 등록 필요 없음 어짜피 이 페이지를 부르는 거라
        /*
        현제 겟요청 페이지와 포스트 담당하는 url이 달라서 이름을 지정한것임 근데 현제 url이 같아서 안넣어도 됨 자기 페이지 로딩하는거라
         */
        out.write("<table>");
        out.write("  <tr>");
        out.printf("     <td colspan=\"4\" class=\"output\">%s</td>",exp);  //printf 로 포멧팅 해서 넘기면 연산 값 출력 가능
        out.write(" </tr>");
        out.write("<tr><!-- name 속성 값은 벨류로 연산자는 오퍼레이터로 -->");
        out.write("    <td><input type=\"submit\" name=\"operator\" value=\"CE\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"operator\" value=\"C\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"operator\" value=\"BS\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"operator\" value=\"/\" /></td>");
        out.write("</tr>");
        out.write("<tr>");
        out.write("   <td><input type=\"submit\" name=\"value\" value=\"7\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"value\" value=\"8\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"value\" value=\"9\" /></td>");
        out.write("   <td><input type=\"submit\" name=\"operator\" value=\"*\" /></td>");
        out.write("</tr>");
        out.write("<tr>");
        out.write("   <td><input type=\"submit\"name=\"value\" value=\"4\" /></td>");
        out.write("   <td><input type=\"submit\" name=\"value\" value=\"5\" /></td>");
        out.write("   <td><input type=\"submit\" name=\"value\" value=\"6\" /></td>");
        out.write("   <td><input type=\"submit\" name=\"operator\" value=\"-\" /></td>");
        out.write("</tr>");
        out.write(" <tr>");
        out.write("   <td><input type=\"submit\" name=\"value\" value=\"1\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"value\" value=\"2\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"value\" value=\"3\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"operator\" value=\"+\" /></td>");
        out.write(" </tr>");
        out.write("<tr>");
        out.write("    <td></td>");
        out.write("    <td><input type=\"submit\" name=\"value\" value=\"0\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"dot\" value=\".\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"operator\" value=\"=\" /></td>");
        out.write(" </tr>");

        out.write(" </table>");

        out.write("</form>");
        out.write("</body>");
        out.write("</html>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

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
            expCookie.setMaxAge(0);

        expCookie.setPath("/Servlet39_one_servlet");
        /*
        이전까지 쿠키 페스 성정 하지 않은 설정 없으면 루트가 되서 이 웹사이트에서 사용되는 모든 url에
        내 쿠키가 전달됨 그게 싫음 이걸 사용하는 url 한정해서 주고 싶음
        그럼 위와 같이 하면 되는데 문제는 이 쿠키를 사용하는 또다른 페이지가 있음
        불행이도 패스 설정은 중첩이 불가임 그래서 루트를 사용해 전역을 사용하던가 해야함

        지금 한페이지 안에 다 넣어놔서 패스 설정 저렇게 하나로 다 가능함 

         */
        res.addCookie(expCookie);
        res.sendRedirect("Servlet39_one_servlet");
        /*
        여기는 이제 경로 지정 안해도 되는게 자기 페이지로 바꾸는거라 (자기가 자기 호출해서)
         */





    }

}
