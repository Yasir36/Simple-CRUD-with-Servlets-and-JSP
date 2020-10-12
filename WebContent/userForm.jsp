<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${user!=null}">
		<form action = "UserController?action=/Update" method = "post">
	</c:if>
	<c:if test="${user==null}">
		<form action = "UserController?action=/Add" method = "post">
	</c:if>
		<div class="form-group">
			<c:if test="${user!=null}">			
				<input type="hidden" class="form-control" id="id" name="id" value = <c:out value = '${user.userID }'/> aria-describedby="emailHelp">
			</c:if>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">First Name</label> 
			<c:if test="${user==null}">
			<input type="text" class="form-control" id="firstNameInput" name="firstName" aria-describedby="emailHelp">
			</c:if>
			<c:if test="${user!=null}">
			<input type="text" class="form-control" id="firstNameInput" name="firstName" value = <c:out value = '${user.firstName }'/> aria-describedby="emailHelp">
			</c:if>
		</div>
	
		<div class="form-group">
			<label for="exampleInputPassword1">Last Name</label> 
			<c:if test="${user==null}">
			<input type="text" class="form-control" id="lastNameInput" name="lastName">
			</c:if>
			<c:if test="${user!=null}">
			<input type="text" class="form-control" id="lastNameInput" name="lastName" value = <c:out value = '${user.lastName }'/>>
			</c:if>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>