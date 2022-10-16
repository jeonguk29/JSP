package iducs.javaweb.fundmentals201912047final;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/member/hello-servlet")// 여기서 / 하면 웹앱과 레빌이 똑같음
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() { // 서블릿 클래스로 부터 서블릿 객체를 생성할 때 호출
        // -> 서블릿  
        // init 은 딱 한번만 실행되기 때문에 각각 브라우저 크롬, 웨일 주소 따로 따로 접근하면 doget은 두번 동작하지만 init은 한번만 호출됨
        // one time 한번만 실행됨 이클레스로부터 객체 생성할때 한번만 실행됨 두번째부터는 메모리에 상주 되어있어서 실행 X
        // doget은 요청이 올때마다 처리 될 코드들을 넣어주면됨
        // 서비스 함수는 스레드를 생성할때 생성되는것임 더 찾아보기
        message = "Hello World! wwwdwewd wedwd";
        System.out.println("one time"); // 콘솔창에 출력
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter(); // 응답 객체로 부터 출력 객체를 생성하여 출력, 웹 브라우저로 전송
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}