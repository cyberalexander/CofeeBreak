<%--
  Created by IntelliJ IDEA.
  User: alexanderleonovich
  Date: 01.09.15
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>
    <tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
  </title>
  <link rel="stylesheet" href="<c:url value="/assests/css/common.css"/>">
  <!-- JQuery scripts -->
  <script src="<c:url value="/assests/jquery/jquery-2.1.4.js"/>" type="text/javascript"></script>
  <!-- Latest compiled and minified JavaScript -->
  <script src="<c:url value="/assests/js/bootstrap.js"/>" type="text/javascript"></script>
  <script src="<c:url value="/assests/jquery/jquery-migrate-1.2.1.js"/>" type="text/javascript"></script>
</head>
<body style="background-color: #FFF">
<div class="cantainer">
  <tiles:insertAttribute name="header"/>
  <tiles:insertAttribute name="body"/>
  <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>
