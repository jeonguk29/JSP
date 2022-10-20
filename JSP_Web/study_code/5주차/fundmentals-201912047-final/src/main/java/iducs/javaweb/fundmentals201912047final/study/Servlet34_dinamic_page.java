package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet34_dinamic_page", value = "/Servlet34_dinamic_page")
public class Servlet34_dinamic_page extends HttpServlet {

    // 세션사용시 HttpServletRequest 이렇게 해줘야함
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8"); // 값 보내줄대
        req.setCharacterEncoding("UTF-8");// 읽을때도 UTF 8로 읽어라 현제 CharacterEncoding 필터를 사용함


        /*
            이전까지는 정적 페이지를 전달했음 (미리 만들어 둔) 이제는
            동적으로 값을 만들어서 값 까지 전해 주는 동적 페이지 (서버 쪽에서 만들어 주기 때문에 서버 페이지라고 함)를 전달 해볼 것임
            즉 서블릿으로 만들어 전달 할거임
            출력 객체를 이용하여

            아래 처음이자 마지막으로 서블릿을 직접 만들어 보았음

          */

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
        out.write("<form action=\"../Servlet34_dinamic_page\" method=\"post\">");
        out.write("<table>");
        out.write("  <tr>");
        out.printf("     <td colspan=\"4\" class=\"output\">%d</td>",3+4);  //printf 로 포멧팅 해서 넘기면 연산 값 출력 가능
        out.write(" </tr>");
        out.write("<tr><!-- name 속성 값은 벨류로 연산자는 오퍼레이터로 -->");
        out.write("    <td><input type=\"submit\" name=\"operator\" value=\"CE\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"operator\" value=\"C\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"operator\" value=\"BS\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"operator\" value=\"÷\" /></td>");
        out.write("</tr>");
        out.write("<tr>");
        out.write("   <td><input type=\"submit\" name=\"value\" value=\"7\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"value\" value=\"8\" /></td>");
        out.write("    <td><input type=\"submit\" name=\"value\" value=\"9\" /></td>");
        out.write("   <td><input type=\"submit\" name=\"operator\" value=\"X\" /></td>");
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
