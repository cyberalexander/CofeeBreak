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
    <div class="container" style="text-align: center">

            <h1>COFFEEBREAK.COM</h1>
            <p class="lead">
                COFFEEBREAK - это сервис предоставляющий всем желающим возможность заказать лучший в Мире
                кофе не отходя от компьютера. Доставка в пределах МКАД - 30 минут.
            </p>
            <c:if test="${cuccess ne null}">
                <hr/>
                <h4 class="inform">${cuccess}</h4>
                <hr/>
            </c:if>
            <sec:authorize access="!isAuthenticated()">
                <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">SIGN IN</a>
                <a class="btn btn-info" href="/registration" role="button">SIGN UP</a></p>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <p>Ваш логин: <sec:authentication property="principal.username" /></p>
                <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a></p>

            </sec:authorize>

    </div>
</div>
