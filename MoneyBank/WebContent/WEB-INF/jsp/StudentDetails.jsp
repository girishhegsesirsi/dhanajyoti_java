<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Information</title>
</head>
<body>
<h1>${defaultMessage}</h1>
<table>
<tr><td>Student id: </td><td>${student1.id}</td></tr>
<tr><td>Student name: </td><td>${student1.name}</td></tr>
<tr><td>Student Contact Number: </td><td>${student1.mobile}</td></tr>
<tr><td>Student Date Of Birth: </td><td>${student1.DOB}</td></tr>
<tr><td>Student Skill set: </td><td>${student1.skills}</td></tr>
<tr><td>Student Address: </td>
<tr><td>Street: </td><td>${student1.studentAddress.street}</td></tr>
<tr><td>City: </td><td>${student1.studentAddress.city}</td></tr>
<tr><td>State: </td><td>${student1.studentAddress.state}</td></tr>
</table>
</body>
</html>