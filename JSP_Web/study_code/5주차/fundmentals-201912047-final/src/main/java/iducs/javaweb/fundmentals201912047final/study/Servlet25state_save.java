package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet25state_save", value = "/Servlet25state_save")
public class Servlet25state_save extends HttpServlet {


    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8"); // 값 보내줄대
        req.setCharacterEncoding("UTF-8");// 읽을때도 UTF 8로 읽어라 현제 CharacterEncoding 필터를 사용함
        PrintWriter out = res.getWriter();






        ServletContext application = req.getServletContext(); //  application 저장소에 저장 할거임
        String v_ = req.getParameter("v");
        String op = req.getParameter("operator");


        int v = 0;

        if(!v_.equals("")) v = Integer.parseInt(v_);

        if(op.equals("=")){

            int x = (Integer)application.getAttribute("value");
            // = 이면 이전거 저장된거 가져옴 반환시 오브젝트 객체라 형변환 해줌
            int y = v; // 현재 불러옴 값
            String operator = (String)application.getAttribute("op"); // 연산자 불러옴
            int result = 0;

            if(operator.equals("+"))
                result = x + y;
            else
                result = x - y;

            res.getWriter().printf("result is %d\n", result);
        }
        else {
            // map 컬렉션 사용한다고 생각하면 편함
            application.setAttribute("value", v);
            application.setAttribute("op", op);
        }




        int result = 0;





    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
