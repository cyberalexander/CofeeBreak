<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexanderleonovich
  Date: 01.09.15
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper">
        <h3 class="inquiry-h3">REGISTRATION FORM</h3>
    <div  class="container"  style="width: 950px; text-align: center">
        <c:url var="post_url"  value="/save/customer" />
        <s:form method="post" modelAttribute="customerDTO" action="${post_url}">
            <table>
                <tr>
                    <td>
                        <label for="firstName">First Name of Customer: </label>
                    </td>
                    <td>
                        <s:input path="firstName" id="firstName" value="${customerDTO.firstName}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="lastName">Last Name of Customer: </label>
                    </td>
                    <td>
                        <s:input path="lastName" id="lastName" value="${customerDTO.lastName}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="login">Login of Customer: </label>
                    </td>
                    <td>
                        <s:input path="login" id="login" value="${customerDTO.login}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="password">Password of Customer: </label>
                    </td>
                    <td>
                        <s:input type="password"  path="password" id="password" value="${customerDTO.password}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center"><input class="btn btn-info" type="submit" value="Save me"/></td>
                </tr>
            </table>
        </s:form>
    </div>
</div>