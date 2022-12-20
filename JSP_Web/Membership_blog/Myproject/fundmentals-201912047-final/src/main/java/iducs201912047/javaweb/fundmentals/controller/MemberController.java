package iducs201912047.javaweb.fundmentals.controller;

import iducs201912047.javaweb.fundmentals.model.Member;
import repository.MemberDAO;
import repository.MemberDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MemberController", urlPatterns = {"/members/create.do","/members/detail.do",
        "/members/list.do", "/members/update.do", "/members/delete.do",
        "/members/login.do","/members/logout.do"})
// 각 버튼에 따라 경로 설정 해줌 값이 여러개면 urlPatterns 로 바꾸기 하나일때 values
public class MemberController extends HttpServlet {
    MemberDAO memberDAOImpl = new MemberDAOImpl(); // Data Access Object 생성

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(); // session 객체를 가져옴

        String uri = request.getRequestURI(); // URI 정보를 가져옴  URL보다 좀더 포괄적인 부분
        String action = uri.substring(uri.lastIndexOf('/') + 1);
       // uri가 http://localhost:8081/members/list 인 경우
        // list 단어의 시작점 : uri.lastIndexOf('/') + 1)

        // 즉 /members-create", "members-list", "/members-update", "/members-delete" 에 따라 메소드를 실행 하겠다.


        // doGet
        if(action.equals("list.do")) {
            System.out.println("list.do");
            List<Member> memberList = memberDAOImpl.readList();// JCF : Java Collection Framework, 집합 개체 조작
            for(Member m : memberList)
                System.out.println(m.getEmail()); // 쓸때 없는 확인 코드 콘솔 확인
            // 링크드리스트를 자바로 구현한 List<Member> memberList에 저장 자바는 객체를 잘처리하는 언어이기 때문에 이렇게 객체화 함
            if (memberList != null) {
                request.setAttribute("list", memberList); // 디비에서 가져온 memberList를 전달 members 로 정의한
                // members-list.jsp에 el로 정의한 이름과 같아야함
                request.getRequestDispatcher("list.jsp").forward(request, response); // 요청을 계속 여기로 전달
            } else {
                ; // 질의가 없는 경우
            }
//        for(Member m : memberList)
//            System.out.println(m.getTname());
            // get 방식일땐 readList 함수 불러옴 : 목록보기 , post 일때는 등록 하기 create 함수 불러옴  : 생성
        }
        else if (action.equals("create.do")) {  // doPost
            int ret = 0;
            Member m = new Member();

            m.setEmail(request.getParameter("email")); //form의 필드값을 객체의 필드값으로 설정
            m.setPw(request.getParameter("pw"));
            m.setName(request.getParameter("name"));
            m.setPhone(request.getParameter("phone"));
            m.setAddress(request.getParameter("address"));

            if((ret = memberDAOImpl.create(m)) > 0){
                request.getRequestDispatcher("../main/index.jsp").forward(request,response);
            }else
                request.setAttribute("message", "회원 등록 실패"); // 출력 정보를 전달
                request.getRequestDispatcher("../status/fail.jsp").forward(request,response);
        }
        else if (action.equals("update.do")){
            //System.out.println("update.do");
            int ret = 0;
            Member m = new Member();
            m.setEmail(request.getParameter("email")); //form의 필드값을 객체의 필드값으로 설정
            m.setName(request.getParameter("name"));
            m.setPhone(request.getParameter("phone"));
            m.setAddress(request.getParameter("address"));

            if((ret = memberDAOImpl.update(m)) > 0){
                request.setAttribute("m", m); // 출력 정보를 전달
                request.getRequestDispatcher("../members/detail-form.jsp").forward(request, response);
            }else {
                request.setAttribute("message", "회원정보 수정에 실패"); // 출력 정보를 전달
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        }
        else if (action.equals("delete.do")){
            int ret = 0;
            Member m = new Member();

            m.setEmail(request.getParameter("email")); //form의 필드값을 객체의 필드값으로 설정
            m.setPw(request.getParameter("pw"));

            if((ret = memberDAOImpl.delete(m)) > 0){
                session.invalidate(); // 성공(탈퇴)했다면 세션 유지 안되게 지워주기 로그아웃 까지 됨
                request.getRequestDispatcher("../main/index.jsp").forward(request,response);
            }else {
                request.setAttribute("message", "회원 탈퇴 실패"); // 출력 정보를 전달
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        }
        else if (action.equals("detail.do")){
            //로그인 코드 가져옴 비슷함
            //System.out.println("detail.do");
            String email = request.getParameter("email"); //매개변수 줄때는 이방식
            //String email = (String)session.getAttribute("logined"); / 아닐때는 이방식
            // 로그인드에 로그인 값 있으니 가져옴

            Member member = new Member(); // 요청을 객체화 하고
            member.setEmail(email);
            Member retMember = null;  // 경로에 보냄

            //select * from member where email=? 이메일 유일키라 레코드 하나 올거임 즉 정보 하나 가져올것임
            if((retMember = memberDAOImpl.read(member)) != null) { // 이메일에 해당 되는 값들이 다 넘어 올거임
                request.setAttribute("m", retMember); // 출력 정보를 전달
                request.getRequestDispatcher("../members/detail-form.jsp").forward(request, response);
                // 가는 놈은 m 만 알수 있음
            } else {
                request.setAttribute("message", "회원정보 상세보기에 실패"); // 출력 정보를 전달
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }

        }

        else if (action.equals("login.do")){
            //System.out.println("login.do");
            String email = request.getParameter("email");
            String pw = request.getParameter("pw"); // 날라오는 거 저장하고
            Member member = new Member(); // 요청을 객체화 하고
            member.setEmail(email);
            member.setPw(pw);
            Member retMember = null;  // 경로에 보냄
            if((retMember = memberDAOImpl.login(member)) != null) { // 로그인 함수에 보냄
                session.setAttribute("logined", retMember.getEmail()); // 로그인 상태 유지
                session.setAttribute("name", retMember.getName()); // 로그인 상태 유지
                // page -> request -> session -> application 객체의 속성을 유지

                request.setAttribute("message", retMember.getName()); // 출력 정보를 전달
                request.getRequestDispatcher("../main/index.jsp").forward(request, response);
                // 로그인 성공시 메인페이지로 이동
            } else {
                request.setAttribute("message", "로그인 실패"); // 출력 정보를 전달
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }

        }
        else if (action.equals("logout.do")){
            session.invalidate();
            request.getRequestDispatcher("../members/login-form.jsp").forward(request,response);
            // 로그아웃시 첫 페이지로 "../main/index.jsp"  지금은 로그인 페이지로 다시감
        }

    }



        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    doProcess(request,response);

    }
    // get 방식일땐 readList 함수 불러옴 : 목록보기 , post 일때는 등록 하기 create 함수 불러옴  : 생성
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }
}
