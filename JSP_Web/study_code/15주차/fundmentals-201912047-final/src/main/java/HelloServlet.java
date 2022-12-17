import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")// 여기서 / 하면 웹앱과 레빌이 똑같음
public class HelloServlet extends HttpServlet {
    private String message;

    // 객체로 부터 생성된 스레드(객체)가 요청을 처리할때
    public void init() { // 서블릿 클래스로 부터 서블릿 객체를 생성할 때 호출
        // -> 서블릿  
        // init 은 딱 한번만 실행되기 때문에 각각 브라우저 크롬, 웨일 주소 따로 따로 접근하면 doget은 두번 동작하지만 init은 한번만 호출됨
        // one time 한번만 실행됨 이클레스로부터 객체 생성할때 한번만 실행됨 두번째부터는 메모리에 상주 되어있어서 실행 X
        // doget은 요청이 올때마다 처리 될 코드들을 넣어주면됨
        // 서비스 함수는 스레드를 생성할때 생성되는것임 더 찾아보기
        message = "Hello World!";
        System.out.println("init()"); // 콘솔창에 출력
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8"); // 서블릿 출력시 charset=UTF-8 옵션 없으면 한글 깨짐 하지만 여기서 출력 할게 아니라면 필요 없음
        // 출력 있는 서블릿 ,jsp 파일에 선앤해줌
        System.out.println("doGet()");// 그냥 콘솔에 나옴
        // 요청 객체에 저장된 매개변수의 값을 가져옴
        System.out.println(request.getParameter("fullname"));
        System.out.println(request.getParameter("email"));

        // html -> 서블릿 -> jsp 처리 순서임

        // about.jsp로 전달하고 싶다.
        // PrintWriter 객체를 생성해서 HTML 문서를 생성 할 것인가? 만들어져 있는 JSP 문서를 활용할 것인가?
        request.getRequestDispatcher("about.jsp").forward(request,response);// 전달 안될수 있어서 위에  ServletException 추가


        /*
        // Hello 웹 화면에 출력시
        PrintWriter out = response.getWriter(); // 응답 객체로 부터 출력 객체를 생성하여 출력, 웹 브라우저로 전송
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        */


    }

    public void destroy() {
    }
}