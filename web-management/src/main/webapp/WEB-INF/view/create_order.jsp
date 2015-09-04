<%--
  Created by IntelliJ IDEA.
  User: alexanderleonovich
  Date: 01.09.15
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wrapper">
    <div>
        <h3 class="inquiry-h3">CREATE ORDER MENU</h3>
        <h4 class="information">${success}</h4>

        <div>
            <form method="post" action="<c:url value='/coffeebreak/add/to/order'/>">

                <table class="table table-striped table-condensed table-bordered">
                    <thead class="topic-tr">
                    <tr>
                        <td>SELECT COFFEE</td>
                        <td>SELECT NUMBER OF CUPS</td>
                        <td>ADD TO ORDER</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <select name="coffee" id="coffee">
                                <c:forEach items="${coffeeDTOs}" var="coffeeDTO">
                                    <option value="${coffeeDTO.coffeeId}">${coffeeDTO.sort}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <select name="number" id="number">
                                <c:forEach items="${numbers}" var="num">
                                    <option value="${num}">${num}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <button type="submit" class="btn btn-lg btn-info">ADD TO ORDER</button>
                        </td>
                    </tr>
                    </tbody>
                </table>

            </form>

            <table class="table table-striped table-condensed table-bordered">
                <thead class="main-tr">
                <tr>
                    <td>Cofee ID</td>
                    <td>Sort</td>
                    <td>Description</td>
                    <td>Number of cups</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${coffeeOrder}" var="coffeeOrder">
                    <tr>
                        <td>${coffeeOrder.coffeeId}</td>
                        <td>${coffeeOrder.sort}</td>
                        <td>${coffeeOrder.description}</td>
                        <td>${coffeeOrder.numberOfCups}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <c:if test="${coffeeOrder != null}">
                        <td colspan="4" style="text-align: center">
                            <a class="btn btn-lg btn-info"
                               href="<c:url value='/coffeebreak/create/order/address'/>">NEXT STEP</a>
                        </td>
                    </c:if>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
