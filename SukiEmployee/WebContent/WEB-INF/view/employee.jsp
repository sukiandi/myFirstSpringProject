<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Employee Management</title>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
	<script src="<c:url value="/resources/js/script.js" />"></script>
</head>
<body>
<h1>
	New Employee Entry
</h1>

<form:form method="POST" action="/employee/new" commandName="employee" onsubmit="return validate()">
<table>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input id="name" path="name" />
			<form:hidden path="id" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="Email"/>
			</form:label>
		</td>
		<td>
			<form:input id="email" path="email" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="phone">
				<spring:message text="Phone Number"/>
			</form:label>
		</td>
		<td>
			<form:input id="phone" path="phone" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="address">
				<spring:message text="Address"/>
			</form:label>
		</td>
		<td>
			<form:input id="address" path="address" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty employee.name}">
				<input id="updateEmployee" class="btnSmall" type="submit"
					value="<spring:message text="Save"/>" />
			</c:if>
			<c:if test="${empty employee.name}">
				<input id="addEmployee" class="btnSmall" type="submit"
					value="<spring:message text="Add New"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<hr>
<h3>Employee List:</h3>
<c:if test="${!empty employeeList}">
	<table>
	<tr>
		<th width="20%">Name</th>
		<th width="20%">Email</th>
		<th width="15%">Phone Number</th>
		<th width="25%">Address</th>
		<th width="10%">Edit</th>
		<th width="10%">Delete</th>
	</tr>
	<c:forEach items="${employeeList}" var="employee">
		<tr>
			<td width="20">${employee.name}</td>
			<td width="20%">${employee.email}</td>
			<td width="15%">${employee.phone}</td>
			<td width="25%">${employee.address}</td>
			<td width="10%"><a href="<c:url value='/edit/${employee.id}' />" >Edit</a></td>
			<td width="10%"><a href="<c:url value='/delete/${employee.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
