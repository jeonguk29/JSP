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

            <%
            int x = 3;
            int y = 4;
            // int page = 1;   이렇게 해주면 오류남
                /*
                       로컬 변수가 중복 되었다고 나옴
                       이 코드블럭 말고 코드가 있다는 것임 jsp 가 만드는 서블릿 안에는 우리가 모르는 자기가 만드는 변수가 있다는 것임
                       제스퍼에서 만들어낸 변수들 (객체들을 담고 있음 ex request , response..) 들을 내장 객체라고 함

    그동안 request 객체 라는 입력을 위한 도구를 많이 써왔는데 사용자가 전달한 파라메터를 입력받을때 등 다양한 메서드들이 정의 되어 있음
    ex getParameterNames()
                */
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