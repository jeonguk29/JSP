package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet38_Get_Post_method", value = "/Servlet38_Get_Post_method")
public class Servlet38_Get_Post_method extends HttpServlet {
    /*
    @Override

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {



        /*

        지금까지는 사용자가 요청을 보내도 겟, 포스트 요청 다 이 서비스에서 실행 했었음
        이제 겟, 포스트 요청에 특화된 함수들을 이용해 보겠음
        겟 오면 겟 만 처리
        포스트 오면 포스트만 처리


        if(req.getMethod().equals("GET")) // 온게 get 이냐 post냐 주의 여기서 온거 확인 할때는 대문자 사용해야함
        {
            System.out.println("GET 요청이 왔습니다");
        }
        else if(req.getMethod().equals("POST")){
            System.out.println("POST 요청이 왔습니다");
        }

        super.service(req, res);//  우선 이거 주석 처리 해야함 doGet, doPost 없다면
        // url 은 있지만 메서드를 처리 할수 없다는 405 에러가 남
        //부모의 서비스를 사용함으로서 doGet, doPost 함수 이용 하겠다고 선언했는데 아래 구현 하지 않았기 때문임
        //부모의 서비스는 Get, Post 인지해서 doGet, doPost 함수 쪽으로 넘겨줌

        // 즉 전체 로직은 서비스를 통과해서 출력할거 다하고  super.service(req, res); 만나서 doGet, doPost 둘중 한 곳으로 감
        // 공통으로 할게 있다면 서비스에 하고 넘기고
        // 아니면 서비스 따로 만들지말고 각각 구현 하면됨 알아서 절로 가게 되어있음
        // 그래서 서비스 함수 주석 처리 해도 문제 없음

    }
*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet 메소드가 호출 되었습니다.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPOST 메소드가 호출 되었습니다.");

    }
    // 가장 바람직한건 겟, 포스트 따로 처리하겠다 하면 이코드만 두고
    // 만약 겟과 포스트 같이 처리 할게 있다면 서비스 함수 오버라이드하고 super.service(req, res); 주석 처리 하는게 가장 바람직함
}
