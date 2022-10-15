/*
package iducs.javaweb.fundmentals201912047final.study;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebFilter(filterName = "CharacterEncodingFilter", value="/*")// web.xml 말고 어노테이션 연결
public class CharacterEncodingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);

        //System.out.println("before filter");

        request.setCharacterEncoding("UTF-8");// 컨테이너 들어가기전 인코딩 작업

       chain.doFilter(request,response); // 흐름을 이야기함 이전 코드가 필터 들어가기전 즉 서블릿 컨테이너 처리전
        // 이 아래코드가 필터 들어가서 서블릿 컨테이너 돌고 처리 나올때 코드 일반 적인 흐름으로 설정했는데 출력 나올때 이상하다 싶으면 다르게 흘러가도록 설정도 가능

        //System.out.println("after filter");

    }
}
*/