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
        <h3 class="inquiry-h3">EDIT COFFEE FORM</h3>
        <s:form method="post" modelAttribute="coffeeDTO" action="/coffee/edit">
            <s:input path="coffeeId" value="${coffeeDTO.coffeeId}" type="hidden"/>
            <table>
                <tr>
                    <td>
                        <label for="sort">Sort: </label>
                    </td>
                    <td>
                        <s:input path="sort" id="sort" value="${coffeeDTO.sort}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="description">Description: </label>
                    </td>
                    <td>
                            <s:textarea rows="3" cols="70" name="description" path="description"/><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="cost">Cost: </label>
                    </td>
                    <td>
                        <s:input cssClass="input-block-level" type="number"  path="cost"
                                 id="cost" value="${coffeeDTO.cost}" min="1" max="1000" step="0.5"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><input class="btn btn-info" type="submit" value="Update Coffee"/></td>
                </tr>
            </table>
        </s:form>
    </div>
</div>