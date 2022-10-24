<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!-- page 지시자 코드블럭이라고 하지는 않음 이 페이지를 어떤 방식에 인코딩 방식으로 사용할것인지를 정의
우리가 서블릿에서 출력하기전 UTF-8 출력하겠다 설정한적 있었음
똑같이 jsp도 어떠한 출력을 하는데 있어서 먼저 이것을 정의 해주는 것임
지시자를 통해 지시하는 것은 어떠한 출력을 진행하는 것보다 앞서서 진행하기 때문에 미리 적는게 좋음 
-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
input{
    width: 50px;
    height: 50px;
}
.output{
    height: 50px;
    background: #e9e9e9;
    font-size: 24px;
    font-weight: bold;
    text-align: right;
    padding: 0px 5px;
}
    </style>

</head>
<body>
<form action="../Servlet40_jsp_start" method="post">
    <table>
        <tr>
            <td colspan="4" class="output">${3+6}</td>
            <!--
            그냥 html이 아님
            {3+4} 해주면 계산이 됨
            서블릿 변경되면 서버 재시작 했었는데 요청할때마다 달라진게 있으면 제스퍼 즉 jsp는 다시 만들어줌 서버 재시작 필요 없음
            우리가 지금 왼쪽에 폴더 디렉토리 막 있는건 개발 디렉토리고 브라우저는 여기를 보지 않음
            우리가 실행하고자 할때 배포하게 되면 톰켓에 홈 디렉토리로 감
            jsp가 단순 출력이 아니라 코드로서 인식 하려면 아래와 같이 코드 블럭 만들면 됨

            이건 코드야 서블릿 안에다 자바 코드 그대로 넣을거니까 출력하면 안된다. 라고 알려주는 것

            -->
            <%
            int x = 3;
            int y = 4;
            %>
            <h3>y 값은 : <%= y%>  아래 코드 귀찮으면 이렇게 해줄수 있음 </h3>
            <h3>y 값은 : <% out.print(y);%></h3>

            <h3>이렇게 멤버 함수는 ! 붙여줘야함 맵버 변수및 출력하는 놈들은 서비스 함수로 가는데 자바에서는
            메서드 안에 메서드 정의 못함 그래서 이렇게 멤버 메서드를 만들어 주는 것임   </h3>
            <%!
                public int sum(int a, int b)
                {
                    return  a+b;
                }
            %>
        </tr>
        <tr><!-- name 속성 값은 벨류로 연산자는 오퍼레이터로 -->
            <td><input type="submit" name="operator" value="CE" /></td>
            <td><input type="submit" name="operator" value="C" /></td>
            <td><input type="submit" name="operator" value="BS" /></td>
            <td><input type="submit" name="operator" value="/" /></td>
        </tr>
        <tr>
            <td><input type="submit" name="value" value="7" /></td>
            <td><input type="submit" name="value" value="8" /></td>
            <td><input type="submit" name="value" value="9" /></td>
            <td><input type="submit" name="operator" value="*" /></td>
        </tr>
        <tr>
            <td><input type="submit" name="value" value="4" /></td>
            <td><input type="submit" name="value" value="5" /></td>
            <td><input type="submit" name="value" value="6" /></td>
            <td><input type="submit" name="operator" value="-" /></td>
        </tr>
        <tr>
            <td><input type="submit" name="value" value="1" /></td>
            <td><input type="submit" name="value" value="2" /></td>
            <td><input type="submit" name="value" value="3" /></td>
            <td><input type="submit" name="operator" value="+" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="value" value="0" /></td>
            <td><input type="submit" name="dot" value="." /></td>
            <td><input type="submit" name="operator" value="=" /></td>
        </tr>

    </table>

</form>
</body>
</html>