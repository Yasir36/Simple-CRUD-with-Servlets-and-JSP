<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href = "style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<title>CRUD</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
		style="padding-top: 20px; padding-bottom: 20px">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Features</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Pricing</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container" style="margin-top: 100px">
		<button href="UserServlet" type="button" class="btn btn-dark" data-toggle="modal" data-target="#staticBackdrop" style="float:left; margin-bottom:10px">ADD USER</button>
		<table class="table table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Operations</th>
				</tr>
			</thead>
			<tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.userID}" /></td>
                    <td><c:out value="${user.firstName}" /></td>
                    <td><c:out value="${user.lastName}" /></td>
                    <td >
                    	 <a href="/UserServlet?action=edit" class="edit-link">Edit</a>
                    	 <a href="DeleteUser?id=${user.userID }" class="delete-link">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
		</table>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-backdrop="static"
		data-keyboard="false" tabindex="-1" role="dialog"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Add User</h5>				
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="AddUser">
				<div class="modal-body" >
				
					  <div class="form-group">
					    <label for="firstNameInput">First Name</label>
					    <input type="text" class="form-control" name="firstName" placeholder="Enter First Name">
					  </div>
					  <div class="form-group">
					    <label for="lastNameInput">Last Name</label>
					    <input type="text" class="form-control" name="lastName" placeholder="Enter Last Name">
					  </div>
				    
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary" name="AddButton" value="addUser">Add</button>
				</div>
				</form>
			</div>
		</div>
	</div>






	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>