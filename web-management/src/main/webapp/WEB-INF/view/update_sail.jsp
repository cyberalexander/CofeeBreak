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
    <h3 class="inquiry-h3">UPDATE SAIL FORM</h3>
    <div class="container"  style="width: 950px; text-align: center">
        <s:form method="post" modelAttribute="sailDTO" action="/sail/update/sail">
            <s:input path="id" value="${sailDTO.id}" type="hidden"/>
            <table>
                <tr>
                    <td>
                        <label for="freeCup">EACH FREE CUP: </label>
                    </td>
                    <td>
                        <s:input cssClass="input-block-level" type="number" size="2" path="freeCup"
                                 id="freeCup" value="${sailDTO.freeCup}" min="0" max="10"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="freeDelivery">FREE DELIVERY AFTER: </label>
                    </td>
                    <td>
                        <s:input cssClass="input-block-level" type="number" path="freeDelivery"
                                 id="freeDelivery" value="${sailDTO.freeDelivery}" min="10" max="100" step="0.5"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="delivery">DELIVERY PRICE: </label>
                    </td>
                    <td>
                        <s:input cssClass="input-block-level" type="number" path="delivery"
                                 id="delivery" value="${sailDTO.delivery}" min="2" max="20" step="0.5"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center"><input class="btn btn-info" type="submit" value="Update Sail"/></td>
                </tr>
            </table>
        </s:form>
    </div>
</div>