<%--
  Created by IntelliJ IDEA.
  User: alexanderleonovich
  Date: 01.09.15
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="wrapper">

    <div class="container"  style="width: 300px; text-align: center">
        <c:if test="${cuccess ne null}">
            <hr/>
            <h4 class="inform">${cuccess}</h4>
            <hr/>
        </c:if>
        <c:url value="/j_spring_security_check" var="loginUrl" />
        <form action="${loginUrl}" method="post">
            <h2 class="form-signin-heading">Please, sign in!</h2>
            <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value="CyberAlexander">
            <input type="password" class="form-control" name="j_password" placeholder="Password" required value="1234"><br/>
            <button class="btn btn-success" type="submit">SIGN IN</button>
        </form>
        <form action="/registration">
            <button class="btn btn-info" type="submit">SIGN UP</button>
        </form>

    </div>

</div>
