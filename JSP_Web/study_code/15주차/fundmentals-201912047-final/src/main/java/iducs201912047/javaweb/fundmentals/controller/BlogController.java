package iducs201912047.javaweb.fundmentals.controller;

import iducs201912047.javaweb.fundmentals.model.Blog;
import iducs201912047.javaweb.fundmentals.model.Member;
import repository.BlogDAO;
import repository.BlogDAOImpl;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BlogController", urlPatterns = {"/blogs/post-form.do", "/blogs/post.do",
        "/blogs/get.do", "/blogs/detail.do",
        "/blogs/update-form.do",  "/blogs/update.do",  "/blogs/delete.do",})
                                                    // 폼을 듸우는놈 , 질의 샐행하는 메서드
public class BlogController extends HttpServlet {


    protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(); // session 객체를 가져옴
        String uri = request.getRequestURI(); // URI 정보를 가져옴  URL보다 좀더 포괄적인 부분
        String action = uri.substring(uri.lastIndexOf('/') + 1); //마지막 슬래시 뒷부분을 서브스트링화

        BlogDAO blogDAOImpl = new BlogDAOImpl();
        //

        if(action.equals("post-form.do")){
            // 아이디와 패스워드 넣어 보내주려고 함
            Member member = new Member();
            member.setEmail((String) session.getAttribute("logined")); // 로그인했을때 세션에 무엇을 넣느냐 확인 해야함
            // 멤버컨트롤러에 login.do 확인하기
            member.setName((String) session.getAttribute("name"));
            request.setAttribute("member",member);
            request.getRequestDispatcher("blog-post-form.jsp").forward(request,response);
        }
        else if(action.equals("post.do")){
            int ret = 0;

            Blog m = new Blog();
            m.setTitle(request.getParameter("title"));
            m.setContent(request.getParameter("content"));
            m.setAuthor(request.getParameter("author"));
            m.setEmail(request.getParameter("email")); //form의 필드값을 객체의 필드값으로 설정
            m.setRegdate(request.getParameter("regdate")); //form의 필드값을 객체의 필드값으로 설정


            if((ret = blogDAOImpl.create(m)) > 0){
                request.getRequestDispatcher("../status/success.jsp").forward(request,response);
            }else
                request.setAttribute("message", "회원 등록 실패"); // 출력 정보를 전달
                request.getRequestDispatcher("../status/fail.jsp").forward(request,response);
        }
        else if(action.equals("get.do")) {
            List<Blog> blogList = new ArrayList<Blog>();

            // id 값을 넣어 reed 함수로 전달
            if ((blogList = blogDAOImpl.readList()) != null) { // 정상
                request.setAttribute("blogs", blogList); // 출력 정보를 전달
                request.getRequestDispatcher("../blogs/list-view.jsp").forward(request, response);
            } else
                request.setAttribute("message", "블로그 목록 조회 실패 "); // 출력 정보를 전달
            request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
        }
        else if(action.equals("detail.do") && request.getParameter("id") != null) {
            Blog ret = new Blog();
            Blog blog = new Blog();
            blog.setId(Long.parseLong(request.getParameter("id")));

            // id 값을 넣어 reed 함수로 전달
            if ((ret = blogDAOImpl.read(blog)) != null) { // 정상
                request.setAttribute("blog", ret); // 출력 정보를 전달
                request.getRequestDispatcher("../blogs/detail-form.jsp").forward(request, response);
            } else
                request.setAttribute("message", "블로그 상세 조회 실패 "); // 출력 정보를 전달
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
        }
        else if (action.equals("update.do")) {
            //System.out.println("update.do");
            int ret = 0;
            Blog b = new Blog();
            b.setTitle(request.getParameter("title")); //form의 필드값을 객체의 필드값으로 설정
            b.setContent(request.getParameter("content"));
            b.setRegdate(request.getParameter("regdate"));
            b.setAuthor(request.getParameter("author"));
            b.setEmail(request.getParameter("email"));
            session = request.getSession();
            //System.out.println(session.getAttribute("logined"));
            //System.out.println(request.getParameter("email"));
            String y = (String) session.getAttribute("logined");
            if(y == null){
                y = "flase";
            }
            String y2 = (String) request.getParameter("email");


            if( y.equals(y2) ) {
                if ((ret = blogDAOImpl.update(b)) > 0) {
                    request.setAttribute("blog", b); // 출력 정보를 전달
                    request.getRequestDispatcher("../blogs/detail-form.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "회원정보 수정에 실패"); // 출력 정보를 전달
                    request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
                }
            }else {
                request.setAttribute("message", "작성자만 수정 삭제가 가능합니다."); // 출력 정보를 전달
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        }
        else if (action.equals("delete.do") && request.getParameter("id") != null){
            int ret = 0;

            Blog blog = new Blog();
            blog.setId(Long.parseLong(request.getParameter("id")));

            session = request.getSession();
            //System.out.println(session.getAttribute("logined"));
            //System.out.println(request.getParameter("email"));
            String y = (String) session.getAttribute("logined");
            if(y == null){
                y = "flase";
            }
            String y2 = (String) request.getParameter("email");
            System.out.println(y);
            System.out.println(y2);

            if( y.equals(y2) ) {
                if ((ret = blogDAOImpl.delete(blog)) > 0) {
                    // session.invalidate(); // 성공(탈퇴)했다면 세션 유지 안되게 지워주기 로그아웃 까지 됨
                    request.getRequestDispatcher("../blogs/get.do").forward(request, response);
                } else {
                    request.setAttribute("message", "블로그 삭제 실패 작성자만 가능 합니다."); // 출력 정보를 전달
                    request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
                }
            }else {
                request.setAttribute("message", "블로그 삭제 실패 작성자만 가능 합니다."); // 출력 정보를 전달
                request.getRequestDispatcher("../status/fail.jsp").forward(request, response);
            }
        }


    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doService(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doService(request,response);
    }
}
