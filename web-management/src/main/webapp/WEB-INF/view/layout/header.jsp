<%--
  Created by IntelliJ IDEA.
  User: alexanderleonovich
  Date: 01.09.15
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav">
            <li><a href="<c:url value='/index'/>">-=COFEEBREAK=-</a></li>
            <li>
                <a href="<c:url value='/coffeebreak/create/order'/>">Create order</a>
            </li>
            <li><a class="btn-link" href="<c:url value='/coffeebreak/allcoffies'/>" role="button">Coffee menu</a></li>
            <li>
                <div class="searchform">
                    <form class="navbar-search" method="GET" action="<c:url value='/coffee/search' />" accept-charset="utf-8">
                        <input class="input-long search-query" placeholder="Search.." type="text" name="searchString"
                               id="searchString"/>
                        <button type="submit" class="btn btn-small"><i class="icon-search"></i></button>
                    </form>
                </div>
            </li>
        </ul>
        <div>
            <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
                <div style="text-align: right;">
                    <!-- Single button -->
                    <div class="btn-group" style="text-align: right">
                        <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown"
                                aria-expanded="false">
                            MENU<span class="caret"></span></button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="<c:url value="/customer/cabinet" />">My Cabinet</a></li>
                            <li><a href="<c:url value="/customer/orders" />">My Orders</a></li>
                            <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                                <li><a href="<c:url value="/sail/update/sail" />">Edit SAIL</a></li>
                                <li><a href="<c:url value="/coffee/create" />">Add Coffee</a></li>
                            </sec:authorize>
                            <li class="divider"></li>
                            <li><a href="<c:url value="/logout" />">LogOut</a></li>
                        </ul>
                    </div>
                </div>
            </sec:authorize>
        </div>
    </div>
</div>
