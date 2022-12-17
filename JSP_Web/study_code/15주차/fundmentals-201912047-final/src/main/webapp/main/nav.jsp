<%--
  Created by IntelliJ IDEA.
  User: IN302
  Date: 2022-11-01
  Time: 오후 3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light" id="mainNav">
  <div class="container px-4 px-lg-5">
    <a class="navbar-brand" href="../index.jsp">Woogie blog
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      Menu
      <i class="fas fa-bars"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ms-auto py-4 py-lg-0">
        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../blogs/get.do">블로그목록</a></li>

        <c:choose>
        <c:when test="${logined == null}">   <!-- 로그인 안했을때 -->
        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../members/create-form.jsp">등록</a></li>
        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../members/login-form.jsp">로그인</a></li>
        </c:when>
          <c:otherwise>
              <!-- 이렇게 form 호출 후 컨트롤러 호출 -->
              <!--/hello-servlet 웹에서 이렇게 슬래시 하지 않음  여기서 클레스이 있는 벨류에 있는 이름을 사용하는 것임 -->
                <!-- 로그인 했을때-->
              <!-- Controller를 호출 Repository : SQL 질의후 반환 -> member-list.jsp-->
            <c:choose>
            <c:when test="${logined == 'admin201912047@induk.ac.kr'}">
                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../members/list.do">회원 목록조회</a></li>
                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../blogs/post-form.do">블로그작성</a></li>
                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../members/detail.do?email=${sessionScope.logined}">상세정보</a></li>
                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../members/logout.do">로그아웃</a></li>
                </c:when>
                <c:otherwise>
                  <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../blogs/post-form.do">블로그작성</a></li>
                  <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../members/detail.do?email=${sessionScope.logined}">상세정보</a></li>
                  <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="../members/logout.do">로그아웃</a></li>
              </c:otherwise>
            </c:choose>
          </c:otherwise>
      </c:choose>

      </ul>
    </div>
  </div>
</nav>