<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexanderleonovich
  Date: 02.09.15
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper">
    <div>
        <h3 class="inquiry-h3">CHOOSE ADDRESS FOR ORDER</h3>
        <table class="table table-striped table-condensed table-bordered">
            <thead class="main-tr">
            <tr>
                <td>OK</td>
                <td>addressId</td>
                <td>street</td>
                <td>house</td>
                <td>apartment</td>
                <td>customerId</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${addressDTOs}" var="addressDTO">
                <tr>
                    <td>
                        <div class="radio">
                            <label>
                                <c:if test="${addressDTO.addressId eq checkedAddressId}">
                                    <input type="radio" name="check" id="check" value="${addressDTO.addressId}" checked/>
                                </c:if>
                                <c:if test="${addressDTO.addressId ne checkedAddressId}">
                                    <input type="radio" name="check" id="check" value="${addressDTO.addressId}"/>
                                </c:if>
                            </label>
                        </div>
                    </td>
                    <td>${addressDTO.addressId}</td>
                    <td>${addressDTO.street}</td>
                    <td>${addressDTO.house}</td>
                    <td>${addressDTO.apartment}</td>
                    <td>${addressDTO.customerId}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6" style="text-align: center">
                    <h2>
                        <c:if test="${delivery ne null}">
                            TOTAL PRICE IS $${price} And $${delivery} delivery!
                        </c:if>
                        <c:if test="${delivery eq null}">
                            TOTAL PRICE IS $${price} And FREE delivery!
                        </c:if>
                    </h2>
                </td>
            </tr>
            <tr>
                <td colspan="3" style="text-align: center">
                    <a class="btn btn-lg btn-success" href="<c:url value='/add/address'/>">ADD OTHER ADDRESS</a>
                </td>
                <td colspan="3" style="text-align: center">
                    <a class="btn btn-lg btn-info" href="<c:url value='/coffeebreak/commit/order'/>"> COMMIT ORDER</a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>