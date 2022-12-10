package iducs201912047.javaweb.fundmentals.controller;

import iducs201912047.javaweb.fundmentals.model.MemberDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FormController", value = "/controllers") // 폼에 하이퍼 링크 와 여기가 같아야함
// 서블릿에서 / 는 웹앱을 의미  현재 웹앱 및에서는 form.jsp 있음 같은 레밸임 현제
public class FormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // teams 가 DB에서 가져온 정보라고 가정   가져와서 teams 에 넣고 처리해 출력하는 작업
        String[] teams = {"삼성라이온즈", "두산베이스", "기아타이거즈", "SSG랜더스", "키움히어로즈"};

        String[] processedTeams = new String[teams.length];
        for(int i = 0 ; i < 5; i++)
        {
            processedTeams[i] = (i + 1) + ":" + teams[i];
        }

        request.setAttribute("baseball", processedTeams); // 속성으로 설정

        request.getRequestDispatcher("view.jsp").forward(request,response); // 처리된 결과 여기넣으면 여기서 출력하겠다 즉 뷰에서 처리
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 포스트 넘겨줬으니 여기에 작성해여함
        request.setCharacterEncoding("UTF-8"); // 인코딩 (or 디코딩)을 맞게 설정
        System.out.println("here");

        // 현재 request 객체에는 두 개의 매개변수 pname, pemail 값이 저장되어 있음
        //System.out.println(request.getParameter("pemail")); // pemail 매개변수의 값을 가져와 출력

        // 속성-속성값을 request 객체에 저장
        //request.setAttribute("work", "등록");


        // DBMS 또는 파일 등으로 부터 레코들을 가져와서 처리됨
        // DTO (Data Transfer Object) : 데이터 전달 객체
        // DAO (Data Access Object) : 데이터를 접근 (DBMS에 질의 처리)

        MemberDTO mRef = new MemberDTO();  // 모델에 담아서 넘겨주기 위함 위 코드는 그냥 뷰 컨트롤러 반복이고 이건 모델 담아서 뷰로 넘김
        mRef.setName(request.getParameter("pname"));// 여기까지가 vmc 모델의 기본 모델
        mRef.setEmail(request.getParameter("pemail"));
        mRef.setWork("수정");
        // member 속성이름으로 mRef 참조하는 객체를 request 객체에 저장
        request.setAttribute("member", mRef);



        // request 객체의 getRequestDispatcher 메소드로 데이터 객체를 전달할 페이지(view) 접근
        // forward() 메소드로 request, response 객체 전달
        request.getRequestDispatcher("result-view.jsp").forward(request, response);
            // 페이지 찾아오고 request, response 객체 전달 보내기전 값 하나 추가하고 보내는 것임
    }
}
