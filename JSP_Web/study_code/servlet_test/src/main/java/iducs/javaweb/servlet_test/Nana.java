package iducs.javaweb.servlet_test;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

@WebServlet(name = "NanaServlet", value = "/Nana-servlet")
public class Nana extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //ServletRequest req : 서블릿을 만들때 필요한 요청 도구, ServletResponse res : 출력 도구
        //super.service(req, res);
       // OutputStream os = req.getOutputSteam();
       // printStream out = new PrintStream(os, true);
       // out.println("Hello Servlet!!");
    }
}
