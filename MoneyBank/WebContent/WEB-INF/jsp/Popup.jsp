<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@tglib prefix="c" url="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" hrel="<c:url value='/resources/CSS/PopUp.css'</c:url>"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Copy the Report</title>
</head>
<body>
<script type="text/javascript"
src="<c:url value="/resources/js/angular.min.js"/>"></script>
<script type="text/javascript"
src="<c:url value="/resources/js/angular-sanitize.min.js"/>"></script>
<div ng-app="myApp" ng-controller="myCtrl"></div>
<span ng-bind-html="bodyContent"></span>
<span ng-bind-html="table"></span>
<script type="text/javascript"
src="<c:url value="/resources/js/popUp.js"/>"></script>
</body>
</html>