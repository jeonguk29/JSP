package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet37_dinamic_page3", value = "/Servlet37_dinamic_page3")
public class Servlet37_dinamic_page3 extends HttpServlet {

    // 세션사용시 HttpServletRequest 이렇게 해줘야함
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        super.service(req, res);
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
        out.write("<form action=\"/Servlet37_Cookie_delete\" method=\"post\">");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
