<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Customer details</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	color: #566787;
	background: #f5f5f5;
	font-family: 'Roboto', sans-serif;
}

.table-wrapper {
	background: #fff;
	padding: 20px;
	margin: 30px 0;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.table-title {
	font-size: 15px;
	padding-bottom: 10px;
	margin: 0 0 10px;
	min-height: 45px;
}

.table-title h2 {
	margin: 5px 0 0;
	font-size: 24px;
}

.table-title select {
	border-color: #ddd;
	border-width: 0 0 1px 0;
	padding: 3px 10px 3px 5px;
	margin: 0 5px;
}

.table-title .show-entries {
	margin-top: 7px;
}

.search-box {
	position: relative;
	float: right;
}

.search-box .input-group {
	min-width: 200px;
	position: absolute;
	right: 0;
}

.search-box .input-group-addon, .search-box input {
	border-color: #ddd;
	border-radius: 0;
}

.search-box .input-group-addon {
	border: none;
	border: none;
	background: transparent;
	position: absolute;
	z-index: 9;
}

.search-box input {
	height: 34px;
	padding-left: 28px;
	box-shadow: none !important;
	border-width: 0 0 1px 0;
}

.search-box input:focus {
	border-color: #3FBAE4;
}

.search-box i {
	color: #a0a5b1;
	font-size: 19px;
	position: relative;
	top: 2px;
	left: -10px;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table td:last-child {
	width: 130px;
}

table.table td a {
	color: #a0a5b1;
	display: inline-block;
	margin: 0 5px;
}

table.table td a.view {
	color: #03A9F4;
}

table.table td a.edit {
	color: #FFC107;
}

table.table td .delete {
	color: #E34724;
}

table.table td i {
	font-size: 19px;
}

.hint-text {
	float: left;
	margin-top: 10px;
	font-size: 13px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
		// Animate select box length
		var searchInput = $(".search-box input");
		var inputGroup = $(".search-box .input-group");
		var boxWidth = inputGroup.width();
		searchInput.focus(function() {
			inputGroup.animate({
				width : "300"
			});
		}).blur(function() {
			inputGroup.animate({
				width : boxWidth
			});
		});
	});
</script>
</head>
<body>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-2">
						<a href="${pageContext.request.contextPath}/secure/customers/add" class="btn btn-success">
						 <span>Add New Customer</span>
						</a>
					</div>
					<div class="col-sm-6">
						<h2 class="text-center">
							Customer <b>Details</b>
						</h2>
					</div>
					<div class="col-sm-4">
						<div class="search-box">
							<div class="input-group">
								<span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
								<input type="text" class="form-control"
									placeholder="Search&hellip;" name="keyword">
							</div>
						</div>
					</div>
				</div>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Address</th>
						<th>phone</th>
						<th>City</th>
						<th>state</th>
						<th>birthDate</th>
						<th>points</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${customers}" var="customer">

						<tr>
							<td>${customer.firstName} ${customer.lastName}</td>
							<td>${customer.address}</td>
							<td>${customer.phone}</td>
							<td>${customer.city}</td>
							<td>${customer.state}</td>
							<td>${customer.birthDate}</td>
							<td>${customer.points}</td>
							<td>
								<form method="post"
									action="${pageContext.request.contextPath}/secure/customers">
									<input type="hidden" name="customerId"
										value="${customer.customerId}" /> 
									<input type="submit" value="Delete" class="btn small" />
								</form> 
								<a href="${pageContext.request.contextPath}/secure/customers?customerId=${customer.customerId}" class="view" title="View" data-toggle="tooltip"><i
									class="material-icons">&#xE417;</i></a> 
								<a href="${pageContext.request.contextPath}/secure/customers/edit?customerId=${customer.customerId}" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
							</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>
