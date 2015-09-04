<%--
  Created by IntelliJ IDEA.
  User: alexanderleonovich
  Date: 02.09.15
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="wrapper">
    <div>
        <c:if test="${cuccess ne null}">
            <hr/>
            <h4 class="inform">${cuccess}</h4>
            <hr/>
        </c:if>
        <c:if test="${cuccess eq null}">
            <h3 class="inquiry-h3">COFFEBREAK MENU</h3>
        </c:if>
        <table class="table table-striped table-condensed table-bordered">
            <thead class="main-tr">
            <tr>
                <td>Cofee ID</td>
                <td>Sort</td>
                <td>Description</td>
                <td>Cost</td>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                    <td>EDIT</td>
                    <td>DELETE</td>
                </sec:authorize>
                <td>
                    <a href="<c:url value="/coffeebreak/add/order"/>"></a>
                </td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${coffeeDTOs}" var="coffeeDTO">
                <tr>
                    <td>${coffeeDTO.coffeeId}</td>
                    <td>${coffeeDTO.sort}</td>
                    <td>${coffeeDTO.description}</td>
                    <td>$${coffeeDTO.cost}</td>
                    <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                        <td><a class="btn btn-small btn-warning"
                               href="<c:url value="/coffee/${coffeeDTO.coffeeId}/edit" />">EDIT</a></td>
                        <td>
                            <form method="post" action="<c:url value="/coffee/${coffeeDTO.coffeeId}/delete" />">
                                <button class="btn btn-small btn-danger">DELETE</button>
                            </form>
                        </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
            <tr>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                    <td colspan="6" style="text-align: center">
                        <a class="btn btn-info" href="<c:url value="/coffeebreak/create/order" />">Create order</a>
                    </td>
                </sec:authorize>
                <sec:authorize access="!hasAnyRole('ROLE_ADMIN')">
                    <td colspan="4" style="text-align: center">
                        <a class="btn btn-info" href="<c:url value="/coffeebreak/create/order" />">Create order</a>
                    </td>
                </sec:authorize>
            </tr>
            </tbody>
        </table>
    </div>
</div>
