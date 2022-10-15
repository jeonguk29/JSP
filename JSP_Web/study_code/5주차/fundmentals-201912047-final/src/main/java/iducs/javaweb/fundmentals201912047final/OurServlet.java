package iducs.javaweb.fundmentals201912047final;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {
                "/OurServlet",  // 같은 이름이 존재하면 안됨
                "/today"
        },
        initParams = {
                @WebInitParam(name = "init-param", value = "init-value")
        })
public class OurServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(); // 요청을 처리하기전에 Servlet 객체 (인스턴스) 초기화 한번만 가능
        System.out.println("init : " + config.getInitParameter("init-param"));
    }
    public OurServlet() {
        System.out.println("constructor : ");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            //service 클라이언트의 HTTP 메소드를 참조하여 해당 메소드를 호출
            throws ServletException, IOException {
        System.out.println("service : ");
        super.service(req, resp);
    }

    // doGet doPost 요청을 처리하는 메소드, 실제로 서비스를 지원한다.
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) {
        System.out.println("doPost : " + request.getParameter("name") + " : " +
                request.getParameter("phone"));
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("doGet : " + request.getParameter("name") + " : " +
                request.getParameter("phone"));
    }
}





