<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
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
        <h3 class="inquiry-h3">ADD ADDRESS FORM</h3>
        <c:url var="post_url"  value="/save/address" />
        <s:form method="post" modelAttribute="addressDTO" action="${post_url}">
            <table>
                <tr>
                    <td>
                        <label for="street">Street: </label>
                    </td>
                    <td>
                        <s:input path="street" id="street" value="${addressDTO.street}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="house">Home: </label>
                    </td>
                    <td>
                        <s:input cssClass="input-block-level"  path="house" id="house"
                                 value="${addressDTO.house}" min="1" max="200" step="1"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="apartment">Apartment: </label>
                    </td>
                    <td>
                        <s:input cssClass="input-block-level" path="apartment"
                                 id="apartment" value="${addressDTO.apartment}" min="1" max="500" step="1"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><input class="btn btn-info" type="submit" value="Save me"/></td>
                </tr>
            </table>
        </s:form>
    </div>
</div>